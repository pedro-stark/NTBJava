package Factory.SimpleFactory.CarFactory;

public class Porsche implements Car{

	private String color;
	
	public Porsche(String color) {
		this.color = color;
	}
	
	public void drive() {
		System.out.println(color + " Porsche starts driving" );
	}
}
