package src.PatternsLoesung_V1.MVC_1_Dec2Bin.v2_mitJavaObserverPattern;


import java.util.Observable;

@SuppressWarnings("deprecation")
public class Model extends Observable {
	private int number;
	
	public Model() {
		number = 0;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		this.setChanged(); //***
		this.notifyObservers(); //***
	}
}
