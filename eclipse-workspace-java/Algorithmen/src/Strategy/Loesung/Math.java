package Strategy.Loesung;

public class Math {
	
	//Datenfeld für aktuelle Strategy
	private Interface_Strategy strategy;
	
	
	public void calculate(int a, int b) {
		//Die eigentliche Operation wird über die Strategy definiert
		
		if(strategy == null) {
			System.out.println("keine Strategy gesetzt");
			return;
		}
		
		int result;
		System.out.println("------------------------");
		System.out.println("Die folgende Operation wurde ausgeführt:");
		
		result = strategy.process(a, b);
		
		System.out.println("Das Resultat ist: " +result);
		System.out.println("------------------------");
	}
	
	public void setStrategy(Interface_Strategy strategy) {
		this.strategy = strategy;
	}
}
