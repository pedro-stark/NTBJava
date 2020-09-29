package Lektion2;
public class Stack {
	private Object[] data;
	private int stackNr = -1; //Array beginnt bei 0
	private int maxSize;

	public Stack(int size) {
		this.maxSize = size;
		this.data = new Object[size];
	}

	public boolean isEmpty() {
		return (stackNr >= 0) ? false : true;
	}
	
	public void push(Object o) {
		if (stackNr +1 >= maxSize) {
			System.out.println("full");
		} else {
			stackNr++;
			data[stackNr] = o;
		}
	}

	public Object pop() {
		Object o = new Object();
		if (stackNr <= 0) {
			System.out.println("empty");
		} else {
			o = data[stackNr];
			data[stackNr] = null;
			stackNr--;
		}
		return o;
	}
}
