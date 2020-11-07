package FactoryMethod.CarFactory;

public class Porsche implements Car{

	String color;
	String interior;
	
	public Porsche(String color) {
		this.color = color;
		this.interior = "leather";
	}
	
	public void show() {
		System.out.println("I am a " + color + " Porsche with " + interior + " interior." );
	}
}
