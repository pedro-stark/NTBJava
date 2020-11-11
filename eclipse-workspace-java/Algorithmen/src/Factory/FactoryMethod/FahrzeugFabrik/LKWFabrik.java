package Factory.FactoryMethod.FahrzeugFabrik;


public class LKWFabrik extends FahrzeugFabrik {
	 
	int dummyzaehler = 0;
	
	public Fahrzeug getFahrzeug(String color) {
		if (dummyzaehler == 0) {
			dummyzaehler = 1;
			return new MAN(color);
		} else if (dummyzaehler == 1) {
			dummyzaehler = 2;
			return new Scania(color);
		} else if (dummyzaehler == 2) {
			dummyzaehler = 0; 
			return new Saurer(color);
		}
		return null; 
	}
}
