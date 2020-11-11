package Factory.FactoryMethod.FormenFabrik;

public class Dim2Fabrik extends FormenFabrik{
	public Form getForm(int ecken) {

		if (ecken == 0) {
			return new Kreis();

		} else if (ecken == 3) {
			return new Dreieck(); 

		} else if (ecken == 4) {
			return new Rechteck(); 
		}
		else {
			return null;
		}
	}
}