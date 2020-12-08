package src.GleitkommazahlenLoesung;

public class AnalyseAufgaben {
	
	public static void a1() {
		float a = 0.0f;
		int i = 1;
		while (i < 10) {			
			// Analyse der Typen
			// a = a + 1.0 / i; 
			// float = float + double / int -> float = float + double -> float = double
			// Typinkompatibilitaet!
			// Loesung a) Variable a zu einem double machen
			// Loesung b) Konstante 1.0 zu einem float machen
			
			a = a + 1.0f / i; // float = float + float / int -> float = float + float -> float = float
			i++;
		}
		System.out.println(a);
	}
	
	public static void a2() {
		int i = 1;
		double a = 0.0;
		while (i < 5) {
			// a = a + 1 / i; 
			// Achtung 1/i int/int fuehrt zu einer Integerdivision mit Ergebnis 0! und somit Aendert sich a nicht!
			// Integerdivision durch double-Division ersetzen
			a = a + 1.0 / i; 
			i++;
		}
		System.out.println(a);
	}
	
	public static void a3() {
		//nie auf Gleichheit vergleichen!
		double a = 0.0;
		do {
			a = a + 0.1;
			System.out.println(a);
		} while (Math.abs(a - 1.0) > 0.001);
	}

	
	public static void main(String[] args) {
		System.out.println("\na1"); a1();
		
		System.out.println("\na2"); a2();
		
		System.out.println("\na3"); a3();
	}
}
