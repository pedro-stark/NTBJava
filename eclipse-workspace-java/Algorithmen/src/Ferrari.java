public class Ferrari implements Fahrzeug{

	private String color;
	
	public Ferrari(String color) {
		this.color = color;
	}
	public void fahren() {
		System.out.println("Auto der Marke Ferrari mit Farbe " + color + " f�ngt an zu fahren");
	}
}
