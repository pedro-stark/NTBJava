
public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(new Integer("5"));
		stack.push(new String("abc"));
		stack.push(new String("abc"));
		stack.push(new String("abc"));
		stack.push(new String("abc"));
		stack.push(new String("abc"));
		stack.push(new String("abc"));
		String s = (String) (stack.pop());
		System.out.println(s);
		
//		for (String printo : args) {
//			System.out.println(args);
			
		System.out.println(stack.isEmpty());
			
		while (stack.isEmpty()) {
			System.out.println(stack.pop());
			
		}
		}
	}


