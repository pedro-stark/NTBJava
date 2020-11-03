package Decorator;

abstract class Decorator_Dolmetscher extends Person {

	protected Person person;

	public Decorator_Dolmetscher(Person person) {
		this.person = person;
	}
	
}
