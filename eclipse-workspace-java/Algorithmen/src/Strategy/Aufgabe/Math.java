package Strategy.Aufgabe;

public class Math {
	
	//Konstanten für Switch-Case
	public final static int ADDITION = 1;
	public final static int SUBTRAKTION = 2;
	public final static int DIVISION = 3;
	public final static int MULTIPLIKATION = 4;
	
	
	public void calculate(int a, int b, int mode) {
		//Welcher Teil des Verhalten ist immer gleich und welcher kann ausgetauscht werden.
		
		int result;
		System.out.println("------------------------");
		System.out.println("Die folgende Operation wurde ausgeführt:");
		
		switch(mode) {
			case ADDITION:
				System.out.println("Addition");
				result = a + b;
				break;
				
			case SUBTRAKTION:
				System.out.println("Subtraktion");
				result = a - b;
				break;
				
			case DIVISION:
				if(b==0) {
					System.out.println("Error");
					result = 9999;
					break;
				}
				System.out.println("Division");
				result = a / b;
				break;
				
			case MULTIPLIKATION:
				System.out.println("Multiplikation");
				result = a * b;
				break;
				
			default:
				System.out.println("Error");
				result = 9999;
				break;
		}
		
		
		System.out.println("Das Resultat ist: " +result);
		System.out.println("------------------------");
	}
}
