package Template.Uebung;

public class SandwichSculptor {
	
	public static void main(String[] args){
		
		System.out.println("---ITALIAN---");
		ItalianHoagie cust12Hoagie = new ItalianHoagie();
		
		cust12Hoagie.makeSandwich();
		
		System.out.println();
		
		
		System.out.println("---VEGGIE---");
		VeggieHoagie cust13Hoagie = new VeggieHoagie();
		
		cust13Hoagie.makeSandwich();
		
	}
	
}
