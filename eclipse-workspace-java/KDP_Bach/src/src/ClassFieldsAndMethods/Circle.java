package src.ClassFieldsAndMethods;
public class Circle {
	//Klassenfeld als Konstante
	public static final double PI = 3.14159; // direkte Initialisierung
	
	//Klassenmethode
	public static double radiansToDegrees(double radians) {
		return radians * 180 / PI;
	}

	//Datenfeld (zum Objekt gehörig)
	public double r; // radius des Kreises
	
	//Methode (zum Objekt gehörig)
	public double area() { return PI * r * r; }
}
