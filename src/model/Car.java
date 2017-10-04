package model;

public class Car extends Vehicle {

	private final String size = "Medium";

	public Car(String license, String color) {
		super(license, color);

	}

	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Car [size=" + size + "]";
	}

}
