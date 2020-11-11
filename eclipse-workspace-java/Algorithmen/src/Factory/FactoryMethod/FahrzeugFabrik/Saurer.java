package Factory.FactoryMethod.FahrzeugFabrik;

public class Saurer implements Fahrzeug{

	private String color;
	
	public Saurer(String color) {
		this.color = color;
	}
	
	public void fahren() {
		System.out.println("LKW der Marke Saurer mit Farbe " + color + " fängt an zu fahren");
	} 
}
   