package src.Ganzzahlen;

public class Basiswechsel {

	public static void main(String[] args) {
		System.out.println("Ziffernausgabe Original");
		ziffernAusgabe(Integer.parseInt(args[0]));

		System.out.println("Ziffernausgabe von rechts nach links");
		ziffernAusgabe_2(Integer.parseInt(args[0]));

		System.out.println("Ziffernausgabe mit 0");
		ziffernAusgabe_3(0);

		System.out.println("Ziffernausgabe zu Basis " + Integer.parseInt(args[1]));
		ziffernAusgabe_4(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	
	}


	//Original aus Uebung
	public static void ziffernAusgabe(int n) {
		int ziffer;
		while (n > 0) {
			ziffer = n % 10;
			System.out.print(ziffer); System.out.print(" ");
			n = n / 10;
		}
		System.out.println();
	}

	public static void ziffernAusgabe_2(int n) {
		//TODO
	}

	public static void ziffernAusgabe_3(int n) {
		//TODO
	}

	public static void ziffernAusgabe_4(int n, int basis) {
		//TODO
	}	
}
