package model;

public class Stack {
	private int maxSize;
	private ParkingSpot[] stackArray;
	private int top;

	public Stack(int max) {
		maxSize = max;
		stackArray = new ParkingSpot[maxSize];
		top = -1;
	}

	public void push(ParkingSpot j) {
		stackArray[++top] = j;
	}

	public ParkingSpot pop() {
		return stackArray[top--];
	}

	public ParkingSpot peek() { 
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
}
