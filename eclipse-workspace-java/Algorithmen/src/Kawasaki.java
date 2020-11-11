public class Kawasaki implements Fahrzeug{

	private String color;
	
	public Kawasaki(String color) {
		this.color = color;
	}
	public void fahren() {
		System.out.println("Motorrad der Marke Kawasaki mit Farbe " + color + " fängt an zu fahren");
	}
}
