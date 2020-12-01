package KW48.u2_3;

//fuer Aufgabe 3
public class Person {
	private final String name;
	private final int age;

	public Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public boolean isAdult() {
		return getAge() >= 18;
	}
	
	public String toString() {
		return name + " (" + age + ")";
	}

}