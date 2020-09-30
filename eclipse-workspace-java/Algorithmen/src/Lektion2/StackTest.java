package Lektion2;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(new Integer("5"));
		stack.push(new String("abc1"));
		stack.push(new String("abc2"));
		stack.push(new String("abc3"));
		stack.push(new String("abc4"));
		stack.push(new String("abc5"));
		stack.push(new String("abc6"));

		System.out.println(stack.isEmpty());

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
