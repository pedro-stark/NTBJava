package Vererbung;

import java.io.Closeable;

public class Katze extends Tier implements Closeable{

	int beine;
	
	public Katze() {
		/*
		 * Konstruktor kann nicht ausgeführt werden, ohne den Konstruktor von Tier zu verwenden
		*/
		super("gelb");
		beine = 4;
	}
	
	public void laufen(int distance, int speed) {
		super.laufen(distance);
		System.out.println("Die Geschwindigkeit beträgt "+ speed+ "km/h");
	}
	
	public void laufen(int distance) {
		super.laufen(distance);
		System.out.println("Klasse Katze");
	}
	
	public void ausgabe() {
		System.out.println("Methode noch zu implementieren");
	}
	
	public void close() {
		System.out.println("Katze wird geschlossen");
	}
	
	public static void main(String args[]) {
		Katze cat = new Katze();
		cat.laufen(2,3);
		Tier t = (Tier)cat;
		t.laufen(1);
		Katze cat2 = (Katze)t;
		cat2.laufen(10,20);
	}
	
	

}
