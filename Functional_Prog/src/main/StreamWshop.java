package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamWshop {
   public static void main(String[] args) {
      List<Staff> staffList = new ArrayList<>();
      staffList.add(new Staff("6c0231c1", "John", 5, 4293));
      staffList.add(new Staff("270d0145", "Mike", 6, 6530));
      staffList.add(new Staff("e75a1d7e", "Jean", 3, 2220));
      staffList.add(new Staff("c1c0a83a", "Kim", 4, 3390));
      
      // Exercise 1: Using streams' forEach(), 
      // print the name of every staff
      System.out.println("[Exercise 1: ForEach]");
      staffList.stream().forEach(x -> System.out.println(x.getName()));

      // Exercise 2: Using streams, compute 
      // the total salary of all staff
      System.out.println("\n[Exercise 2: Sum]");
      float sum = staffList.stream()
      			.map(x -> x.getSalary())
      			.reduce(0f, (output, s1) -> output + s1);
      System.out.println("Sum: " + sum);
      
      // Exercise 3: Using streams' filter(), 
      // retrieve all salary that are more than 
      // 3500 into a List, then print each of the 
      // object within the List
      System.out.println("\n[Exercise 3: Filter]");
      List<Staff> result = staffList.stream()
      			.filter(x -> x.getSalary() > 3500f)
      			.collect(Collectors.toList());
      result.stream().forEach(System.out::println);
      
      
      // Exercise 4: Using streams' map(), print 
      // the list of increments that are less 
      // than 200; given a staff's increment is 
      // such that a grade of 5 and above 
      // will yield a 8% increment (off of the staff's 
      // current salary), while any other grades
      // will only yield a 4% increment.
      System.out.println("\n[Exercise 4: Map]");
      staffList.stream()
      			.map(x-> {
      				double inc;
      				if(x.getGrade() >= 5){
      					inc = 0.08;}
      				else{
      					inc = 0.04;
      				}
      				return x.getSalary() * inc;
      			})
      			.filter(x -> x < 200)
      			.forEach(System.out::println);
      
      // Exercise 5: Using streams' sort(), sort 
      // the staff by salary in ascending 
      // order (least salary first) and print out
      // each staff object
      // You may need to add necessary methods
      // to Staff class
      System.out.println("\n[Exercise 5: Sort]");
      staffList.stream()
      			.sorted(Comparator.comparing(Staff::getSalary))
      			.forEach(System.out::println);
      
      // Exercise 6: Using streams' max(), display 
      // the highest salary among the staff
      System.out.println("\n[Exercise 6: Max]");
      float max = staffList.stream()
      			.map(x -> x.getSalary())
      			.max(Float::compare)
      			.get();
      System.out.println(max);
      
      // Exercise 7: Using streams' reduce(), 
      // implement your own "max" function 
      // to display the highest salary among the staff
      System.out.println("\n[Exercise 7: Reduce");
      float max2 = staffList.stream()
      			.map(x -> x.getSalary())
      			.reduce((output, x) -> {
      				if(x > output) {
      					return x;
      				}
      				return output;
      			})
      			.get();
      System.out.println(max2);
      
   }
}

