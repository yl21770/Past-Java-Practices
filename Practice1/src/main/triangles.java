package main;

import java.util.Scanner;

public class triangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Input side 1: ");
		int input1 = scanner.nextInt();
		
		System.out.print("Input side 2: ");
		int input2 = scanner.nextInt();
		
		System.out.print("Input side 3: ");
		int input3 = scanner.nextInt();
		
		scanner.close();
		
		printTriangle(input1, input2, input3);
		
	}
	
	public static void printTriangle(int side1, int side2, int side3) {
		Boolean eq = side1 == side2 && side1 == side3 && side2 == side3,
				isc = (side1 == side2 || side1 == side3 || side2 == side3) && !eq,
				sca = side1 != side2 && side1 != side3 && side2 != side3;
		
		if(eq) {
			System.out.println("Sides form an Equilateral");
		}
		else if(isc) {
			System.out.println("Sides form an Isosceles");
		}
		else if(sca) {
			System.out.println("Sides form a Scalene");
		}
		else {
			System.out.println("Invalid input");
		}
	}

}
