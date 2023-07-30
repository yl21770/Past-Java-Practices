package main;

public class Main {

	public static void main(String[] args) {
		AnimalChoir choir = new AnimalChoir();
		
		choir.add(new Cat());
		choir.add(new Dog());
		choir.add(new Cat());
		choir.add(new Cow());
		
		choir.sing();
		
		tester(new Animal(), 5);
	}
	
	public static <A extends Animal> void tester(A myAni, int n) {
		for(int i = 0; i<n; i++) {
			myAni.makeSound();
		}
	}

}
