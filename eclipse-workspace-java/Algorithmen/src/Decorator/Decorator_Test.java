package Decorator;

public class Decorator_Test {

	public static void main(String[] args) {

		Person thurgauer = new Sprache_Franzoesisch(new Thurgauer());
		thurgauer.sprechen();
		System.out.println("-----------------------------------");
		
		Person st_galler = new St_Galler();
		st_galler.sprechen();
		System.out.println("-----------------------------------");
		// Implementieren sie eine Dekorierer Klasse "Sprache_Spanisch" um den Code lauffähig zu machen
		st_galler = new Sprache_Spanisch(st_galler);
		st_galler.sprechen();
		System.out.println("-----------------------------------");
		
		//Zusatzaufgabe, bringen Sie dem St. Galler Französisch bei und lassen ihn anschliessend sprechen
		st_galler = new Sprache_Franzoesisch(st_galler);
		st_galler.sprechen();
	}

}
