package Factory.FactoryMethod.FahrzeugFabrik;

public class MAN implements Fahrzeug{

	private String color;
	
	public MAN(String color) {
		this.color = color;
	}
	
	public void fahren() {
		System.out.println("LKW der Marke MAN mit Farbe " + color + " fängt an zu fahren");
	} 
}
   