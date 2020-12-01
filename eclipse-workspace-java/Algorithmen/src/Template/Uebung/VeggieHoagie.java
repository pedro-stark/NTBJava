package Template.Uebung;

public class VeggieHoagie extends Hoagie {

	@Override
	public void addMeat() {
		System.out.println("No meat added");
	}

	@Override
	public void addCheese() {
		System.out.println("No cheese added, sadness only");
	}
	
	@Override
	public void addVegetables() {
		System.out.println("Add all available vegetables, compost included");
	}
}
