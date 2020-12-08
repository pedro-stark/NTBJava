package src.GanzzahlenLoesung;

public class Formatierung {

	public static void main(String[] args) {
	
		int pos = 123456;
		int neg = -123456;
			
		//Standard
		System.out.println("Ausgabe mit println: / " + pos + " / " + neg + " /");

		//Mit format
		//Jeder Parameter wird mit % eingeleitet/
		//dann optional die Parameternummer, hier 1$, 2$
		//dann optional Flags, hier - + 0 , (auch in Kombination)
		//dann optional Breite, hier 20
		//dann die Konvertierung d,x,X,o
		
		System.out.format("Ausgabe mit format (d):  / %1$d / %2$d /\n", pos, neg);
		System.out.format("Ausgabe mit format (x):  / 0x%1$x / 0x%2$x /\n", pos, neg);
		System.out.format("Ausgabe mit format (X):  / 0X%1$X / 0X%2$X /\n", pos, neg);
		System.out.format("Ausgabe mit format (o):  / %1$o / %2$o /\n", pos, neg);

		System.out.format("Ausgabe mit format (w=20,r):                / %1$20d / %2$20d /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,l):                / %1$-20d / %2$-20d /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,r, sign):          / %1$+20d / %2$+20d /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,r, 0):             / %1$020d / %2$020d /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,r, sign, gruppen): / %1$+,20d / %2$+,20d /\n", pos, neg);

		String s = String.format("%d", 123456);
	}

}

//Ganze Zahlen mit String.format formatieren
//siehe https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax

/*
Schreiben Sie ein Testprogramm, mit dem sich Zahlen so ausgegeben werden:
	a. Als Dezimalzahl
	b. Als Hexadezimalzahl (testen sie x und X! Stellen Sie der Ausgabe ein 0X
	voran)
	c. Als Oktalzahl
	d. F�hren Sie nun Flags und eine Width ein!
	i. Linksbündige Ausgabe
	ii. Rechtsbündige Ausgabe
	iii. Ausgabe immer mit Vorzeichen
	iv. Ausgabe mit führenden 0en.
	v. Ausgabe mit 1000er- Gruppierungssymbol
*/