package KW48.u3_3;

public class Person implements Comparable<Person> {
	
	private String vorname;
	private String nachname;
	
	public Person(String v, String n) {
		vorname = v;
		nachname = n;
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String toString() {
		return vorname + " " + nachname;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person)o;
			return vorname.equals(p.vorname) && nachname.equals(p.nachname);
		}
		return false;
	}
	
	public int compareTo(Person p) {
		int r = nachname.compareTo(p.nachname);
		if (r == 0) {
			return vorname.compareTo(p.vorname);
		}
		return r;
	}

}
