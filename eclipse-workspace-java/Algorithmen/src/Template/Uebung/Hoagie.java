package Template.Uebung;

public abstract class Hoagie {

	String[] meatUsed = { "Salami", "Pepperoni", "Capicola Ham" };
	String[] cheeseUsed = { "Provolone" };
	String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
	String[] condimentsUsed = { "Oil", "Vinegar" };
	
public void makeSandwich(){
		
		cutBun();
		addMeat();
		addCheese();
		addVegetables();
		addCondiments();
		wrapTheHoagie();
		
	}
	
	public void cutBun(){
		
		System.out.println("The Hoagie is Cut");
		
	}
	
	public void addMeat(){
		
		System.out.println("Add Salami, Pepperoni and Capicola ham");
		
	}
	
	public void addCheese(){
		
		System.out.println("Add Provolone");
		
	}
	
	public void addVegetables(){
		
		System.out.println("Add Lettuce, Tomatoes, Onions and Sweet Peppers");
		
	}
	
	public void addCondiments(){
		
		System.out.println("Add Oil and Vinegar");
		
	}
	
	public void wrapTheHoagie(){
		
		System.out.println("Wrap the Hoagie");
		
	}
}
