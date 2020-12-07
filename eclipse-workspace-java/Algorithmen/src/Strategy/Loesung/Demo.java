package Strategy.Loesung;

public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
	}
	
	public Demo() {
		Math m = new Math();
		
		m.setStrategy(new Addition());
		m.calculate(5, 4);
		
		m.setStrategy(new Subtraktion());
		m.calculate(3, 5);
		
		m.setStrategy(new Division());
		m.calculate(8, 2);
		
		m.setStrategy(new Multiplikation());
		m.calculate(8, 9);
		
		//Es können nun mit relativ geringem Aufwand weitere Strategien implementiert werden.
	}
}
