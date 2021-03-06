package Aufgaben;

import java.util.Iterator;

public class Basiswechsel {

	public static void ziffernAusgabe(int n) {
		int ziffer;
		int len = (int) Math.log10(n) + 1;
		char[] out = new char[len];

		for (int i = len - 1; i >= 0; i--) {
			ziffer = n % 10;
			out[i] = (char) (ziffer + '0'); // '' ist char, "" ist String
			n = n / 10;
		}
		System.out.println(out);
	}

	public static void ziffernAusgabeRekursiv(int n) {
		int ziffer = n % 10;
		if (n > 0) {
			ziffernAusgabeRekursiv(n / 10);
			System.out.print(ziffer);
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Sie sollten mindestens eine Zahl als Argument �bergeben");
			System.exit(1);
		}
		for (String s : args) {
			System.out.println(s);
		}
		ziffernAusgabe(Integer.parseInt(args[0]));
		ziffernAusgabeRekursiv(Integer.parseInt(args[0]));
	}
}
