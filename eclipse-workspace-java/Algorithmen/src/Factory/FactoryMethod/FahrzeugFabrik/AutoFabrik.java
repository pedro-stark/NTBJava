package Factory.FactoryMethod.FahrzeugFabrik;


public class AutoFabrik extends FahrzeugFabrik {
	 
	int dummyzaehler = 0;
	
	public Fahrzeug getFahrzeug(String color) {
		if (dummyzaehler == 0) {
			dummyzaehler = 1;
			return new Ford(color);
		} else if (dummyzaehler == 1) {
			dummyzaehler = 2;
			return new Porsche(color);
		} else if (dummyzaehler == 2) {
			dummyzaehler = 0; 
			return new Ferrari(color);
		}
		return null; 
	}
}
