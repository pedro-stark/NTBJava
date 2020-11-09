package Factory.FactoryMethod.GeneralFactory;

public class ProdukteFabrikB extends ProdukteFabrik{

	public Produkt getProdukt(String produktart) {
		if (produktart.equalsIgnoreCase("PRODUKT1")){
			return new ProduktB1();
		} else if (produktart.equalsIgnoreCase("PRODUKT2")) {
			return new ProduktB2();
		} else if (produktart.equalsIgnoreCase("PRODUKT3")) {
			return new ProduktB3();
		}
		return null;
	}
}




