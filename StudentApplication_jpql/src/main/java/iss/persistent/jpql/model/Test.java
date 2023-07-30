package iss.persistent.jpql.model;

import java.util.List;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
   public static void main(String[] args) {
      EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA");
      EntityManager entityManager = emFactory.createEntityManager();
      DataService dataService = new DataService(entityManager);

      findAllStudents(dataService);
      
      List<Student> results = dataService.findAllStudentsSortMatric();
      getResults(results);
      
      results = dataService.findAllNStudents();
      getResults(results);
      
      results = dataService.findAllCAPStudents();
      getResults(results);
      
      results = dataService.findAllStudentsOnPage2();
      getResults(results);
      
      results = dataService.findAllMarvelCAPStudents();
      getResults(results);
      
      results = dataService.findAllManStudentsWithModules();
      getStudentsAndModules(results);
      
      List<Department> dpts = dataService.findAllCAPDepartments();
      getResults(dpts);
      
      Student test = dataService.forTesting();
      
      
      entityManager.close();
      emFactory.close();
   }

   static void findAllStudents(DataService ds) {
      List<Student> students = ds.findAllStudents();
      for (Student s: students) {
         System.out.println(s);
      }
   }
   
   static void getResults(List<? extends Object> list) {
	   System.out.println("==========================");
	   list.stream().forEach(System.out::println);
	   System.out.println();
   }
   
   static void getStudentsAndModules(List<Student> list) {
	   System.out.println("==========================");
	   for(Student s: list) {
		   System.out.println(s);
		   
		   for(Module m: s.getModules()) {
			   System.out.println(m);
		   }
		   
		   System.out.println();
	   }
   }
}
