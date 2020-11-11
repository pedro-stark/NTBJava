package Factory.FactoryMethod.FahrzeugFabrik;

public class Scania implements Fahrzeug{

	private String color;
	
	public Scania(String color) {
		this.color = color;
	}
	
	public void fahren() {
		System.out.println("LKW der Marke Scania mit Farbe " + color + " fängt an zu fahren");
	} 
}
   