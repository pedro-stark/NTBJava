package Decorator;

public class Sprache_Franzoesisch extends Decorator_Dolmetscher {
	
	Sprache_Franzoesisch(Person person){
		
		super(person);
	}
	
	public void sprechen() {
		person.sprechen();
		System.out.println("Französisch");
	}

}
