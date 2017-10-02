package model;

public class ParkingSpace {
	private String id;
	private String size;

	public ParkingSpace(String id, String size) {
		super();
		this.id = id;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
