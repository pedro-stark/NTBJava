package FactoryMethod.CarFactory;

public class Ford implements Car{

	String color;
	String interior;
	
	public Ford(String color) {
		this.color = color;
		this.interior = "cloth";
	}
	
	public void show() {
		System.out.println("I am a " + color + " Ford with " + interior + " interior." );
	}

}
