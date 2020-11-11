public class Honda implements Fahrzeug{

	private String color;
	
	public Honda(String color) {
		this.color = color;
	}
	public void fahren() {
		System.out.println("Motorrad der Marke Honda mit Farbe " + color + " fängt an zu fahren");
	}
}
