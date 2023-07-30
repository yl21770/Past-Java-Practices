package main;

public class FindMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer result = max(10, 30, 25);
		
		System.out.println(result);
	}

	static <A extends Comparable<A>> A max (A e1, A e2, A e3) {
		A max = e1;
		
		if (e2.compareTo(max) > 0) {
			max = e2;
		}
		
		if (e3.compareTo(max) > 0) {
			max = e3;
		}
		
		return max;
	}
	
}
