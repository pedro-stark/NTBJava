public class Stack<T> {
	private T[] array;
	private int index;

	Stack(int size) {
		array = new T[size];
	}

	public <E> void put(E e) {
		if (index < array.length) {
			array[index] = e;
			index = index + 1;
		}
	}

	public Object get() {
		if (index == 0)
			return null;
		Object o = array[index];
		index = index - 1;
		return o;
	}
}