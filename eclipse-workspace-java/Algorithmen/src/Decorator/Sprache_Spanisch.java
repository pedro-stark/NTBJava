package Decorator;

public class Sprache_Spanisch extends Decorator_Dolmetscher {
	
	Sprache_Spanisch(Person person){
		
		super(person);
	}
	
	public void sprechen() {
		person.sprechen();
		System.out.println("Spanisch");
	}

}