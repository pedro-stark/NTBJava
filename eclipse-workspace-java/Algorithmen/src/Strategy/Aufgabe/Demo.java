package Strategy.Aufgabe;


/*
 *Auf die Math Klasse soll das Strategy-Pattern angewendet werden
 *Die Konsolenausgabe soll gleich bleiben.
 *Dem Client/Demo sind die einzelnen Strategien bekannt. 
 */

public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
	}
	
	public Demo() {
		Math m = new Math();
		m.calculate(5, 4, Math.ADDITION);
		m.calculate(3, 5, Math.SUBTRAKTION);
		m.calculate(8, 2, Math.DIVISION);
		m.calculate(8, 9, Math.MULTIPLIKATION);
	}
}
