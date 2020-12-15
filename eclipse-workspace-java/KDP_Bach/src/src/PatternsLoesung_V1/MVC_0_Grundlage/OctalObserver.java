package src.PatternsLoesung_V1.MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm


public class OctalObserver extends Observer{

	public OctalObserver(Subject subject){
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Octal String: " + Integer.toOctalString(subject.getState())); 
	}
}
