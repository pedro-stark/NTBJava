package src.ExceptionsLoesung.uebungen;

public class Aufgabe1_ArithmeticException {

	public static void main(String[] args) {
		//Runtime Exceptions müssen nicht abgefangen werden! 
		//(weil sie auf einen Programmierfehler hindeuten)

		try {
			f();			
		} catch (ArithmeticException e) {
			System.err.println("Huch, ein Fehler!");
			e.printStackTrace();
		}
		
		System.out.println("Es geht weiter");
		
		f();
}
	
	public static void f() {
		System.out.println(45 / 0);
		
	}

}
