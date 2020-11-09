package Factory.FactoryMethod.FahrzeugFabrik;

public class Kunde {

	public static void main(String args[]) {
		FahrzeugFabrik ff = new AutoFabrik();
		Fahrzeug auto1 = ff.getFahrzeug("blau"); 
		auto1.fahren();
		
		Fahrzeug auto2 = ff.getFahrzeug("blau");
		auto2.fahren();
		
		Fahrzeug auto3 = ff.getFahrzeug("blau");
		auto3.fahren();
		
		FahrzeugFabrik mf = new MotoFabrik();
		Fahrzeug moto1 = mf.getFahrzeug("rot"); 
		moto1.fahren();
		
		Fahrzeug moto2 = mf.getFahrzeug("rot");
		moto2.fahren();
		
		Fahrzeug moto3 = mf.getFahrzeug("rot");
		moto3.fahren();
		
	}

}
