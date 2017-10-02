package model;

public class Stack {
	private int maxSize;
	private Vehicle[] stackArray;
	private int top;

	public Stack(int max) {
		maxSize = max;
		stackArray = new Vehicle[maxSize];
		top = -1;
	}

	public void push(Vehicle j) {
		stackArray[++top] = j;
	}

	public Vehicle pop() {
		return stackArray[top--];
	}

	public Vehicle peek() { 
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
}
