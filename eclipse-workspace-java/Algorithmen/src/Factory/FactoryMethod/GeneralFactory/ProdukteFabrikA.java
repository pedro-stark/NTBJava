package Factory.FactoryMethod.GeneralFactory;

public class ProdukteFabrikA extends ProdukteFabrik{
	public Produkt getProdukt(String produktart) {
		if (produktart.equalsIgnoreCase("PRODUKT1")){
			return new ProduktA1();
		} else if (produktart.equalsIgnoreCase("PRODUKT2")) {
			return new ProduktA2();
		} else if (produktart.equalsIgnoreCase("PRODUKT3")) {
			return new ProduktA3();
		} 
		return null;
	} 
}




