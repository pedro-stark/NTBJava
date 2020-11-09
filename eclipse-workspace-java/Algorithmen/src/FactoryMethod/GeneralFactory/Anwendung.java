package FactoryMethod.GeneralFactory;

public class Anwendung {

	public static void main(String[] args) {
		ProdukteFabrik pf = new ProdukteFabrik();
		Produktefamilie prod1 = pf.getProdukt("Produkt1");
		prod1.methode();
	}

}
