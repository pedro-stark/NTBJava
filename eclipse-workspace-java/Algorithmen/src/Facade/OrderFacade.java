package Facade;


public class OrderFacade {
	Waiter waiter;
	Kitchen kitchen;
	
	public OrderFacade() {
		this.waiter = new Waiter();
		this.kitchen = new Kitchen();
	}
	
	public void orderFood() {
		waiter.writeOrder();
		waiter.sendToKitchen();
		kitchen.prepareFood();
		kitchen.callWaiter();
		waiter.serveCustomer();
		waiter.getDishes();
		kitchen.washDishes();
	}
}
