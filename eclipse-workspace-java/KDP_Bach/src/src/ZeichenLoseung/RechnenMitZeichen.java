package src.ZeichenLoseung;

public class RechnenMitZeichen {

	public static void main(String[] args) {
		int anz = 'z' - 'a' + 1;
		System.out.println("A1.1: Anzahl Kleinbuchstaben " + anz);

		int ziffer = '7' - '0';
		System.out.println("A1.2: Zeichen '7' zu Ziffer " + ziffer);
		
		int abstand = 'a' - 'A';
		System.out.println("A1.3 Abstand zwichen Gross- und Kleinbuchstaben " + abstand);

		char verschoben = (char)('b' + 3);
		System.out.println("A1.4 Caesar-Verschlüsselung von 'b' " + verschoben);
	}

}
