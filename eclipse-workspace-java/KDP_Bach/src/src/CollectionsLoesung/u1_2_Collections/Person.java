package src.CollectionsLoesung.u1_2_Collections;


public class Person implements Comparable<Person> {

	private String name;
	private String vorname;
	private int geburtsjahr;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

	public Person(String name, String vorname, int geburtsjahr) {
		this.name = name;
		this.vorname = vorname;
		this.geburtsjahr = geburtsjahr;
	}
	
	public String toString() {
		return name + " " + vorname + " (" + geburtsjahr + ")";
	}
	
	public int compareTo(Person p) {
		//1. Name (asc), 2. Vorname (asc)
		int r = name.compareTo(p.name);
		if (r == 0) {
			return vorname.compareTo(p.vorname);
		}
		return r;
	}
}
