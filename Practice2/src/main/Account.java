package main;

public class Account {
	private String number;
	private int balance;
	
	public Account(String number, int balance) {
		this.number = number;
		this.balance = balance;
	}
	
	public Account() {
		this("", 0);
	}
	
	public String Number() {
		return number;
	}
	
	public int Balance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void Deposit(int deposit) {
		this.balance += deposit;
	}
}
