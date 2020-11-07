package Facade;


public class Waiter {

	public void writeOrder() {
		System.out.println(" Waiter writes client's order");
	}

	public void sendToKitchen() {
		System.out.println(" Send order to kitchen");
	}
	
	public void getDishes() {
		System.out.println(" Waiter brings dishes to the kitchen");
	}

	public void serveCustomer() {
		System.out.println(" Customer is served!!!");
	}

}
