package main;

public class Cow extends Animal{
	public Cow() {}
	
	@Override
	public void makeSound() {
		System.out.println("Moo~");
	}
}
