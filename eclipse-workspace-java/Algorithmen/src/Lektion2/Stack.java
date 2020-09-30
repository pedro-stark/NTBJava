package Lektion2;

public class Stack {
	private Object[] data;
	private int stackNr = -1; // Array beginnt bei 0
	private int maxSize;

	public Stack(int size) {
		this.maxSize = size;
		this.data = new Object[size];
	}

	public boolean isEmpty() {
		boolean isEmpty;
		if (stackNr > -1) {
			isEmpty = false;
		} else {
			isEmpty = true;
		}
		return isEmpty;
	}

	public void push(Object o) {
		if (stackNr >= maxSize -1) {
			System.out.println("full");
		} else {
			stackNr++;
			data[stackNr] = o;
		}
	}

	public Object pop() {
		Object o = new Object();
		if (stackNr <= -1) {
			System.out.println("empty");
		} else {
			o = data[stackNr];
			data[stackNr] = null;
			stackNr--;
		}
		return o;
	}
}
