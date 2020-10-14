package Rekursion;

public class Hofstadler {

	public static int[] Hofstad(int bis) {
		int[] hof = new int[bis+1];
		hof[0] = 1;
		hof[1] = 1;

		System.out.println("Hofstad 0 = " + hof[0]);
		System.out.println("Hofstad 1 = " + hof[1]);

		for (int i = 2; i < bis + 1; i++) {
			hof[i] = hof[i - hof[i - 1]] + hof[i - hof[i - 2]];
			System.out.println("Hofstad " + i + " = " + hof[i]);
		}
		return hof;
	}

	public static void main(String[] args) {
		int[] hofstad100;
		hofstad100 = Hofstad(100);
		
		

	}

}
