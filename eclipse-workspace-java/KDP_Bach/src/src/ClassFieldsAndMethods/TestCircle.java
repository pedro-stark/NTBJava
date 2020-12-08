package src.ClassFieldsAndMethods;

public class TestCircle {

	public static void main(String[] args) {
		//Zugriff auf ein Klassenfeld
		System.out.println("PI = " + Circle.PI);
		
		//Zugriff auf eine Klassenmethode
		System.out.println("0.785 rad = " + Circle.radiansToDegrees(0.785) + " deg");
		
		//************************************************************************************
		
		//Objekterzeugung
		Circle c1 = new Circle();

		//Objektinitialisierung durch direkten Zugriff auf ein Objektfeld;
		c1.r = 1.0;
		
		//Aufruf einer Objektmethode
		System.out.println("Fläche von c1 mit Radius " + c1.r + ": " + c1.area());
		
		//Berechnung des Umfangs von c1
		double u = 2.0 * c1.r * Circle.PI;
		System.out.println("Umfang von c1 mit Radius " + c1.r + ": " + u);
		
	}

}
