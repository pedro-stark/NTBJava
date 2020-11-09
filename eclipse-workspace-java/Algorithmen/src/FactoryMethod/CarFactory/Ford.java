package FactoryMethod.CarFactory;

public class Ford implements Car{

	private String color;
	
	public Ford(String color) {
		this.color = color;
	}
	
	public void drive() {
		System.out.println(color + " Ford starts driving" );
	}

}
