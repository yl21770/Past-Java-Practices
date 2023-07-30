package main;

public class Dog extends Animal{
	public Dog() {}
	
	@Override
	public void makeSound() {
		System.out.println("Woof!");
	}
}
