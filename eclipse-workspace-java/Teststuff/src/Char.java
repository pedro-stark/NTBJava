
public class Char {

	public Char() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		char ch1 = 'a';
		char ch2 = 'A';
		char ch3 = '\u0050';
		
		System.out.println(ch3);
		
		System.out.println((char)(ch1 + ch2));
		
		System.out.println(Character.isUpperCase(ch1));
		System.out.println(Character.isUpperCase(ch3));
	}
}
