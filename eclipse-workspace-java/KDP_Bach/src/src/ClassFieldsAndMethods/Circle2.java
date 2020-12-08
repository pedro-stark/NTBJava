package src.ClassFieldsAndMethods;
public class Circle2 {
	//Klassenfelder
	public static final double PI = 3.14159; // direkte Initialisierung
	public static int noOfInstances;
	
	//Initialisierung von Klassenfeldern in einem static-Block
	static {
		noOfInstances = 0;
	}
	
	//Klassenmethode
	public static double radiansToDegrees(double radians) {
		return radians * 180 / PI;
	}
	
	
	//Konstruktor
	public Circle2(double radius) {
		r = radius;
		noOfInstances++;
	}

	//Datenfeld (zum Objekt gehörig)
	public double r; // radius des Kreises
	
	//Methode (zum Objekt gehörig)
	public double area() { return PI * r * r; }
}
