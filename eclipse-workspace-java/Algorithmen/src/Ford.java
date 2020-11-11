public class Ford implements Fahrzeug{

	private String color;
	
	public Ford(String color) {
		this.color = color;
	}
	
	public void fahren() {
		System.out.println("Auto der Marke Ford mit Farbe " + color + " fängt an zu fahren");
	}

}
