package Factory.FactoryMethod.FahrzeugFabrik;

public class Porsche implements Fahrzeug{

	private String color;
	
	public Porsche(String color) {
		this.color = color;
	}
	
	public void fahren() {
		System.out.println("Auto der Marke Porsche mit Farbe " + color + " fängt an zu fahren");
	}
}
