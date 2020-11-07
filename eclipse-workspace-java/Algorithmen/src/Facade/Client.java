package Facade;


public class Client {
	public static void main(String[] args) {
		// Simple for the client
		// no need to know the order or the
		// dependencies among the subsystem.
		OrderFacade facade = new OrderFacade();
		facade.orderFood();
	}
}
