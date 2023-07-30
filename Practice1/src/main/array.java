package main;

public class array {

	public static void main(String[] args) {
		GetMax();
		System.out.println();
		GetSum();
	}
	
	public static void GetMax() {
		// TODO Auto-generated method stub
		int[] array1 = new int[] {1, 2, 2, 5, 3, 4, 5, 5, 2};
		int max = 0, count = 0;
		
		for(int i = 0; i < array1.length; i++) {
			if(max < array1[i]) {
				max = array1[i];
			}
		}
		
		for(int number: array1) {
			if(number == max) {
				count += 1;
			}
		}
		
		System.out.println("Max value: " + max);
		System.out.println("Number of occurrences: " + count);
	}
	
	public static void GetSum() {
		int[] array1 = new int[] {1, 2, 2, 5, 3, 4, 5, 5, 2};
		Boolean isEven;
		int evenSum = 0, oddSum = 0;
		
		for(int number: array1) {
			isEven = number % 2 == 0;
			
			if(isEven) {
				evenSum += number;
			}
			else {
				oddSum += number;
			}
		}

		System.out.println("Sum of even numbers: "+ evenSum);
		System.out.println("Sum of odd numbers: "+ oddSum);
	}

}
