package model;

public class ParkingSpot {
	private long id;
	private String size;
	public ParkingSpot(long id, String size) {
		super();
		this.id = id;
		this.size = size;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
