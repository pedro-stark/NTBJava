package src.ExceptionsLoesung.uebungen;

public class Aufgabe1_ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		//Runtime Exceptions m�ssen nicht abgefangen werden! 
		//(weil sie auf einen Programmierfehler hindeuten)
		
		System.out.println(args[3]);
	}

}
