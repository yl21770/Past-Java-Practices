package mainpackage;

public class Facility {
	private String name, description;
	
	public Facility(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Facility(String name) {
		this(name, "");
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", name, description);
	}
	
	public void show() {
		System.out.printf("Facility name: %s ", name);
		
		if(description != "") {
			System.out.printf("| Description: %s", description);
		}
		
		System.out.println();
	}
}
