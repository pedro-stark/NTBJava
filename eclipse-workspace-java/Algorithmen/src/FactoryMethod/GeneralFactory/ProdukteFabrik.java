package FactoryMethod.GeneralFactory;

public class ProdukteFabrik {

	public Produktefamilie getProdukt(String produktart) {
		if (produktart.equalsIgnoreCase("PRODUKT1")){
			return new Produkt1();
		} else if (produktart.equalsIgnoreCase("PRODUKT2")) {
			return new Produkt2();
		} else if (produktart.equalsIgnoreCase("PRODUKT3")) {
			return new Produkt3();
		}
		return null;
	}
}




