package Test;

public class Gleitkommazahlentest {

	public static void main(String[] args) {
		double a, b, c;
		a = 1 + (double) Math.pow(2, -30);
		b = 1 - (double) Math.pow(2, -30);
		c = a - b;
		System.out.println(c);
	}
}
