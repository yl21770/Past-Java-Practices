package main;

import java.util.Scanner;

public class pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Input an integer less than 20: ");
		int input = scanner.nextInt();
		
		scanner.close();
		
		for (int i = input; i > 0; i--) {
			for(int j = 1; j<=i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}
