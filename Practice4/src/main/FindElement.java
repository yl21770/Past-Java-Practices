package main;

public class FindElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intarr = {1, 2, 3, 4, 5};
		Integer input = 7;
		
		if(find(intarr, input)) {
			System.out.println("Found!");
		}
		else {
			System.out.println("Not found...");
		}
		
		String[] strarr = {"alpha", "beta", "gamma"};
		String input2 = "betaX";
		
		if(find(strarr, input2)) {
			System.out.println("Found!");
		}
		else {
			System.out.println("Not found...");
		}
	}

	public static <A> boolean find(A[] arr, A input) {	
		for(A value: arr) {
			if(value == input) {
				return true;
			}
		}
		
		return false;
	}
}
