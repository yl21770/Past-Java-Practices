package main;

import java.util.Arrays;

public class AnimalChoir {
	private Animal[] animals;
	
	public AnimalChoir() {
		this.animals = new Animal[0];
	}
	
	public void add(Animal animal) {
		animals = Arrays.copyOf(animals, animals.length + 1);
		animals[animals.length - 1] = animal;
	}
	
	public void sing() {
		for(Animal animal: animals) {
			animal.makeSound();
		}
	}
	
}
