package src.Patterns.MVC_3_JTable.v0.model;

public class Person implements Comparable {
	private String name;
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

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	private String vorname;
	private int alter;
	
	public Person(String n, String v, int a) {
		name = n;
		vorname = v;
		alter = a;
	}
	
	public String toString() {
		return name + " " + vorname + " (" + alter +")";
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person p = (Person)o;
			
			//sortierung Name, Vorname, alter
			int res = name.compareTo(p.name);
			if (res == 0) {
				
				res = vorname.compareTo(p.vorname);
				if (res == 0) {
					res = vorname.compareTo(p.vorname);
					
					return alter - p.alter;
					
				} else {
					return res;
				}
			} else {
				return res;
			}
		}
		return 0;
	} 
}
