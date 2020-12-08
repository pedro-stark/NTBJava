package src.Patterns.MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm


public class DecimalObserver extends Observer{

	public DecimalObserver(Subject subject){
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Decimal String: " + subject.getState()); 
	}
}
