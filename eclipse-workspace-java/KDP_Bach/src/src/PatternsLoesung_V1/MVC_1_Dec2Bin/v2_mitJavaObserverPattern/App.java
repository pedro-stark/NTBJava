package src.PatternsLoesung_V1.MVC_1_Dec2Bin.v2_mitJavaObserverPattern;

public class App {

	public static void main(String[] args) {
		Model m = new Model();
		
		new ViewController(m);
		View2 v = new View2(m); v.setLocation(0,  150);
	}
}
