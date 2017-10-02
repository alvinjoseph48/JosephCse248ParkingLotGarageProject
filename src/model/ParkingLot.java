package model;

public class ParkingLot {
	private int zipCode;
	private int parkingSpotsNum;
	private int parkingLevelsNum;

	public ParkingLot(int zipCode, int parkingSpotsNum, int parkingLevelsNum) {
		super();
		this.zipCode = zipCode;
		this.parkingSpotsNum = parkingSpotsNum;
		this.parkingLevelsNum = parkingLevelsNum;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getParkingSpotsNum() {
		return parkingSpotsNum;
	}

	public void setParkingSpotsNum(int parkingSpotsNum) {
		this.parkingSpotsNum = parkingSpotsNum;
	}

	public int getParkingLevelsNum() {
		return parkingLevelsNum;
	}

	public void setParkingLevelsNum(int parkingLevelsNum) {
		this.parkingLevelsNum = parkingLevelsNum;
	}

}
