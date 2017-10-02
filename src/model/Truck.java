package model;

public class Truck extends Vehicle {

	public Truck(String license, String color) {
		super(license, color);
	}

	private final String size = "Large";

	public String getSize() {
		return size;
	}
}
