package Factory.FactoryMethod.FahrzeugFabrik;


public class MotoFabrik extends FahrzeugFabrik {

	int dummyzaehler = 0;
	
	public Fahrzeug getFahrzeug(String color) {

		if (dummyzaehler == 0) {
			dummyzaehler = 1;
			return new Kawasaki(color);
		} else if (dummyzaehler == 1) {
			dummyzaehler = 2;
			return new Yamaha(color);
		} else if (dummyzaehler == 2) {
			dummyzaehler = 0;
			return new Honda(color);
		}
		return null; 
	}

} 
 