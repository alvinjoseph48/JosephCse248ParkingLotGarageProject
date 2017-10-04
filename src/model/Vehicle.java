package model;

public class Vehicle {

	private String license;
	private String color;

	public Vehicle(String license, String color) {
		this.license = license;
		this.color = color;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String lisence) {
		this.license = lisence;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [license=" + license + ", color=" + color + "]";
	}
	

}
