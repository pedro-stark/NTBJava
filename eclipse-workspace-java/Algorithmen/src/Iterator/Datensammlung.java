package Iterator;

public class Datensammlung {
	private Object daten[];
	private int maxAnzDaten;
	private int aktAnzDaten;
	private int cursor;
	
	public Datensammlung(int max) {
		daten = new Object[max];
		maxAnzDaten = max; 
		aktAnzDaten = 0;
	}
	
	public void insert(Object o) {
		if (maxAnzDaten >= aktAnzDaten) {
			daten[aktAnzDaten++] = o;
			System.out.println(o);
		}else {
			System.out.println("FULL");
		}
	}
	
	public static void main(String args[]) {
		Datensammlung d = new Datensammlung(5);
		d.insert("Dummy1");
		d.insert("Dummy2");
		d.insert("Dummy3");
	}
	
}
