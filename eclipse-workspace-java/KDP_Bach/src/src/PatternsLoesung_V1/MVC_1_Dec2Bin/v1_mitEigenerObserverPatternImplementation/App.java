package src.PatternsLoesung_V1.MVC_1_Dec2Bin.v1_mitEigenerObserverPatternImplementation;

public class App {

	public static void main(String[] args) {
		Model m = new Model();
		ViewController v1 = new ViewController(m); 
		ViewController v2 = new ViewController(m); v2.setLocation(0, 150);
	}

}
