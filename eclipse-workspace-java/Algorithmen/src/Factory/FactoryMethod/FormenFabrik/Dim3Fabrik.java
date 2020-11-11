package Factory.FactoryMethod.FormenFabrik;

public class Dim3Fabrik extends FormenFabrik{
	public Form getForm(int ecken) {

		if (ecken == 0) {
			return new Kugel();

		} else if (ecken == 5) {
			return new Pyramide();

		} else if (ecken == 8) {
			return new Wuerfel(); 
		}
		else { 
			return null;
		}
	}
}