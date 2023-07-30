package main;


public class GetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Short[] arr = {1, 2, 3, 4, 5};
		double result = Summer(arr);
		
		System.out.println(result);
	}
	
	public static <A extends Number> double Summer(A[] arr) {
		double sum = 0;
		
		for(A value: arr) {
			sum += value.doubleValue();
		}
		
		return sum;
	}

}
