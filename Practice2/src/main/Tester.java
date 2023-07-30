package main;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account myacc = new Account();
		
		System.out.println(myacc.Number());
		System.out.println(myacc.Balance());
		
		myacc.setBalance(100);
		
		myacc.Deposit(700);
		
		System.out.println(myacc.Balance());
	}

}
