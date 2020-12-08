package MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm

public class ObserverPatternDemo {
	public static void main(String[] args) {
		//Model
		Subject subject = new Subject();

		//3 Views
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");	
		subject.setState(15);
		
		System.out.println();
		System.out.println("Second state change: 10");	
		subject.setState(10);
	}
}