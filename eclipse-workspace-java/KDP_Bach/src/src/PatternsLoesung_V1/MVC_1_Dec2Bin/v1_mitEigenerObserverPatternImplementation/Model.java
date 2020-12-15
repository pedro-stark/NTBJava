package src.PatternsLoesung_V1.MVC_1_Dec2Bin.v1_mitEigenerObserverPatternImplementation;

import java.util.*;

public class Model {
	private int number;
	private List<ViewController> views; //****
	
	public Model() {
		views = new ArrayList<ViewController>(); //****
		number = 0;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (this.number != number) {
			this.number = number;
			this.notifyObservers(); //****
		}
	}
	
	public void attach(ViewController v) { //****
		views.add(v);
	}
	
	private void notifyObservers() { //****
		for (ViewController view : views) {
			view.update();	
		}
	}

}
