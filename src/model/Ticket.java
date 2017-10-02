package model;

public class Ticket {

	private String licensePlate;
	private double cost;
	private int ticketNum;

	public Ticket(String licensePlate, double cost, int ticketNum) {
		super();
		this.licensePlate = licensePlate;
		this.cost = cost;
		this.ticketNum = ticketNum;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

}
