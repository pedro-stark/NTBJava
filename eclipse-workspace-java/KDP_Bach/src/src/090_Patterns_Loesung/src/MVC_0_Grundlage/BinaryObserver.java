package MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm


public class BinaryObserver extends Observer{

	public BinaryObserver(Subject subject){
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toBinaryString(subject.getState())); 
	}
}
