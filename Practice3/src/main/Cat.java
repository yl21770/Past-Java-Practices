package main;

public class Cat extends Animal{
	public Cat() {}
	
	@Override
	public void makeSound() {
		System.out.println("Meow~");
	}
}
