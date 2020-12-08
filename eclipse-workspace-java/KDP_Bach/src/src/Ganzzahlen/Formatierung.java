package src.Ganzzahlen;

public class Formatierung {

	public static void main(String[] args) {
	
		int pos = 123456;
		int neg = -123456;
			
		//Standard
		System.out.println("Ausgabe mit println: / " + pos + " / " + neg + " /");
		
		//Doku
		//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/PrintStream.html
		//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...)
		//
		//Formatbeschreibung:
		//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html#syntax
		//und dort für Ganzzahlen: 
		//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html#dnint
		
		//Mit format
		//Jeder Parameter wird mit % eingeleitet/
		//dann optional die Parameternummer, hier 1$, 2$
		//dann optional Flags, hier - + 0 , (auch in Kombination)
		//dann optional Breite, hier 20
		//dann die Konvertierung d,x,X,o
		
		System.out.format("Ausgabe mit format (d):  / %1$d / %2$d /\n", pos, neg);
		
		//YOUR CODE GOES HERE: immer die ??? ersetzen!
		System.out.format("Ausgabe mit format (x):  / ??? / ??? /\n", pos, neg);
		System.out.format("Ausgabe mit format (X):  / ??? / ??? /\n", pos, neg);
		System.out.format("Ausgabe mit format (o):  / ??? / ??? /\n", pos, neg);

		System.out.format("Ausgabe mit format (w=20,r):                / ??? / ??? /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,l):                / ??? / ??? /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,r, sign):          / ??? / ??? /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,r, 0):             / ??? / ??? /\n", pos, neg);
		System.out.format("Ausgabe mit format (w=20,r, sign, gruppen): / ??? / ??? /\n", pos, neg);

		//das ganze geht auch direkt auf Strings:
		String s = String.format("%d", 123456);
		System.out.println(s);
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
	d. Führen Sie nun Flags und eine Width ein!
	i. LinksbÃ¼ndige Ausgabe
	ii. RechtsbÃ¼ndige Ausgabe
	iii. Ausgabe immer mit Vorzeichen
	iv. Ausgabe mit fÃ¼hrenden 0en.
	v. Ausgabe mit 1000er- Gruppierungssymbol
*/