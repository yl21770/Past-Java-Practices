package main;

import java.util.Scanner;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Input a string: ");
		String input = scanner.next();
		
		scanner.close();
		
		checkString(input);
	}
	
	public static void checkString(String input) {
		boolean valid = true;
		String serial = input.substring(1, input.length() - 1);
		
		if(input.length() != 9 || serial.length() != 7) {
			valid = false;
		}
		
		for(int i = 0; i<serial.length(); i++) {
			if(!Character.isDigit(serial.charAt(i))) {
				valid = false;
			}
		}
		
		if(input.charAt(0)!= 'S' && input.charAt(0)!= 'T' && input.charAt(0)!= 'F' && input.charAt(0)!= 'G') {
			valid = false;
		}
		
		if(!Character.isLetter(input.charAt(input.length() - 1))) {
			valid = false;
		}
		
		if(valid) {
			System.out.println("Input is a NRIC number");
		}
		else {
			System.out.println("Input is not a NRIC number");
		}
	}

}
