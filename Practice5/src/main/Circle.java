package main;

public class Circle implements Comparable<Circle> {
	public double radius;
	public String test;
	
	public Circle(double radius) {
		this.radius = radius;
		this.test = "";
	}
	
	@Override
	public int compareTo(Circle anotherCircle) {
		if(this.radius < anotherCircle.radius) {
			return -1;
		}
		else if(this.radius > anotherCircle.radius) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(radius);
	}
}
