package Vererbung;

public abstract class Tier {
	
	String farbe;
	
	public Tier(String f) {
		farbe = f;
	}
	
	public void laufen(int distance) {
		System.out.println("Tier l�uft "+ distance + "km weit.");
	}
	
	public abstract void ausgabe();
}
