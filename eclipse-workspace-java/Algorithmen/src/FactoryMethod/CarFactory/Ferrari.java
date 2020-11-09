package FactoryMethod.CarFactory;

public class Ferrari implements Car{

	private String color;
	
	public Ferrari(String color) {
		this.color = color;
	}
	public void drive() {
		System.out.println(color + " Ferrari starts driving" );
	}
}
