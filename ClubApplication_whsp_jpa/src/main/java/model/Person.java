package model;

import javax.persistence.*;

@MappedSuperclass
public class Person {
	private String surname, firstName, secondName;
	
	public Person() {}
	
	public Person(String surname, String firstName, String secondName) {
		this.surname = surname;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public Person(String surname, String firstName) {
		this(surname, firstName, "");
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", firstName, secondName, surname);
	}
	
	public void show() {
		String fullname = "";
		
		if(secondName != "") {
			fullname = toString();
		}
		else {
			fullname = firstName + " " + surname;
		}
		
		System.out.printf("Fullname: %s\n", fullname);
	}
}
