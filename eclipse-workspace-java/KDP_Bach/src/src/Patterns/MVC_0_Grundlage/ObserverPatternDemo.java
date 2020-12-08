package src.Patterns.MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm

public class ObserverPatternDemo {
	public static void main(String[] args) {
		//Model, Observable
		Subject subject = new Subject();

		//4 Views - Registrierung
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);
		new DecimalObserver(subject);

		//Aenderungen am Observable/Model! -> Observers werden über das Observable benachrichtigt
		System.out.println("First state change: 15");	
		subject.setState(15);
		
		System.out.println();
		System.out.println("Second state change: 10");	
		subject.setState(10);
	}
}