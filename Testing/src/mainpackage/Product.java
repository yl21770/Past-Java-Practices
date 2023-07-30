package mainpackage;

public class Product {
	private int id;
	 private String name;
	 private String category;
	 private double price;

	 public Product(int i, String name, String category, double price) {
	 this.id = i;
	 this.name = name;
	 this.category = category;
	 this.price = price;
	 }
	 public String toString() {
	 return name + " " + price;
	 }
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	} 
}
