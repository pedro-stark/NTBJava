package Factory.FactoryMethod.GeneralFactory;

public class Anwendung {

	public static void main(String[] args) {
		ProdukteFabrik pfA = new ProdukteFabrikA();
		Produkt prodA1 = pfA.getProdukt("Produkt1");
		prodA1.methode();
		
		ProdukteFabrik pfB = new ProdukteFabrikA();
		Produkt prodB1 = pfB.getProdukt("Produkt1");
		prodB1.methode(); 
	}
}
