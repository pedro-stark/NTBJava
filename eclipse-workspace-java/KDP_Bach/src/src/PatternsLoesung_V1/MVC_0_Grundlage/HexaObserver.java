package src.PatternsLoesung_V1.MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm


public class HexaObserver extends Observer{

	public HexaObserver(Subject subject){
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(subject.getState())); 
	}
}
