package main;

import java.util.Arrays;
import java.util.Comparator;

public class sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle[] myCircles = {
				new Circle(5.0),
				new Circle(1.0),
				new Circle(3.0)
		};
		
		//Arrays.sort(myCircles);
		
		
		Arrays.sort(myCircles, new Comparator<Circle>(){
			@Override
			public int compare(Circle c1, Circle c2) {
				if(c1.radius < c2.radius) {
					return -1;
				}
				else if(c1.radius > c2.radius) {
					return 1;
				}
				else {
					return 0;
				}
			}
		});
		
		for(Circle c: myCircles) {
			System.out.println(c);
		}
	}

}
