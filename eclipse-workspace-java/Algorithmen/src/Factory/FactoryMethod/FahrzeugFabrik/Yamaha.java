package Factory.FactoryMethod.FahrzeugFabrik;

public class Yamaha implements Fahrzeug{

	private String color;
	
	public Yamaha(String color) {
		this.color = color;
	}
	public void fahren() {
		System.out.println("Motorrad der Marke Yamaha mit Farbe " + color + " fängt an zu fahren");
	}
}
