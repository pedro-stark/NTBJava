package src.GanzzahlenLoesung;

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
		int[] stellen = new int[64];
		int s = 0;

		while (n > 0) {
			stellen[s] = n % 10;
			n = n / 10;
			s++;
		}

		//und nun noch die Ausgabe
		while (s > 0) {
			s--;
			System.out.format("%1$X ", stellen[s]);
		}
		System.out.println();
	}

	public static void ziffernAusgabe_3(int n) {
		int[] stellen = new int[64];
		int s = 0;

		while (n > 0) {
			stellen[s] = n % 10;
			n = n / 10;
			s++;
		}

		//und nun noch die Ausgabe
		if (s == 0) {
			System.out.format("%1$X ", 0);
		} else {
			while (s > 0) {
				s--;
				System.out.format("%1$X ", stellen[s]);
			}			
		}		
		System.out.println();
	}

	public static void ziffernAusgabe_4(int n, int basis) {
		int[] stellen = new int[64];
		int s = 0;

		while (n > 0) {
			stellen[s] = n % basis;
			n = n / basis;
			s++;
		}

		//und nun noch die Ausgabe
		if (s == 0) {
			System.out.format("%1$X ", 0);
		} else {
			while (s > 0) {
				s--;
				System.out.format("%1$X ", stellen[s]);
			}			
		}		
		System.out.println();
	}	
}
