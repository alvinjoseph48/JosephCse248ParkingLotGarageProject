package model;

public class Motercycle extends Vehicle {
	private final String size = "Small";
	
	public String getSize() {
		return size;
	}

	public Motercycle(String license, String color) {
		super(license, color);
	}
	

}
