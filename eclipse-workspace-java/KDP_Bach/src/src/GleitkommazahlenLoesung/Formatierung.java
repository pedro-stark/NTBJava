package src.GleitkommazahlenLoesung;

public class Formatierung {

	public static void main(String[] args) {
	
		double gross = 123456.98765E30;
		double klein = -123456.98765;
			
		//Standard
		System.out.println("Ausgabe mit println: / " + gross + " / " + klein + " /\n");

		//mit Konvertierungen e,E, g,G, f: Erklären Sie die Darstellungen!
		System.out.format("Ausgabe mit format (e):  / %1$e / %2$e /\n", gross, klein);
		System.out.format("Ausgabe mit format (E):  / %1$E / %2$E /\n", gross, klein);
		System.out.format("Ausgabe mit format (g):  / %1$g / %2$g /\n", gross, klein);
		System.out.format("Ausgabe mit format (G):  / %1$G / %2$G /\n", gross, klein);
		System.out.format("Ausgabe mit format (f):  / %1$f / %2$f /\n", gross, klein);
		
		//mit Flags zur Präzision: wie oben, aber immer 3 Nachkommastellen 
		System.out.println("\nmit Flags zur Präzision");
		System.out.format("Ausgabe mit format (e):  / %1$.3e / %2$.3e /\n", gross, klein);
		System.out.format("Ausgabe mit format (E):  / %1$.3E / %2$.3E /\n", gross, klein);
		System.out.format("Ausgabe mit format (g):  / %1$.3g / %2$.3g /\n", gross, klein);
		System.out.format("Ausgabe mit format (G):  / %1$.3G / %2$.3G /\n", gross, klein);
		System.out.format("Ausgabe mit format (f):  / %1$.3f / %2$.3f /\n", gross, klein);

		
		//der Rest (Breite, Tausendertrennzeichen etc.) dito wie bei Ganzzahlen 
		System.out.println("\nmit Flags für Tausendertrennzeichen");
		//not allowed: System.out.format("Ausgabe mit format (e):  / %1$,.3e / %2$,.3e /\n", gross, klein);
		//not allowed: System.out.format("Ausgabe mit format (E):  / %1$,.3E / %2$,.3E /\n", gross, klein);
		System.out.format("Ausgabe mit format (g):  / %1$,g / %2$,g /\n", gross, klein);
		System.out.format("Ausgabe mit format (G):  / %1$,G / %2$,G /\n", gross, klein);
		System.out.format("Ausgabe mit format (f):  / %1$,f / %2$,f /\n", gross, klein);
		
	}

}
