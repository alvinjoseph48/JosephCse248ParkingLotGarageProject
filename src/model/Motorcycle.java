package model;

public class Motorcycle extends Vehicle {
	private final String size = "Small";
	
	public String getSize() {
		return size;
	}

	public Motorcycle(String license, String color) {
		super(license, color);
	}
	

}
