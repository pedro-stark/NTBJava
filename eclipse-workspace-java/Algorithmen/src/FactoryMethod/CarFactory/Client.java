package FactoryMethod.CarFactory;

public class Client {

	public static void main(String args[]) {
		CarFactory CF = new CarFactory();
		
		Car car1 = CF.getCar("Porsche", "blue");
		car1.drive();
		
		Car car2 = CF.getCar("Ford", "black");
		car2.drive();
		
		Car car3 = CF.getCar("Ferrari", "red");
		car3.drive();
		
	}

}
