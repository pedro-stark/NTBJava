package FactoryMethod.CarFactory;

public class Ferrari implements Car{

	String color;
	String interior;
	
	public Ferrari(String color) {
		this.color = color;
		this.interior = "leather";
	}
	public void show() {
		System.out.println("I am a " + color + " Ferrari with " + interior + " interior." );
	}
}
