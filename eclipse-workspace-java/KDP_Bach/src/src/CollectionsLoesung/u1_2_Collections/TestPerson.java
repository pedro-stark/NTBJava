package src.CollectionsLoesung.u1_2_Collections;

import java.util.*;

public class TestPerson {
	
	public static void main(String[] args) {
		List<Person> l = new ArrayList<Person>();
		
		l.add(new Person("Z", "B", 2010));
		l.add(new Person("A", "C", 2000));
		l.add(new Person("A", "B", 1900));
		l.add(new Person("A", "B", 2010));
		l.add(new Person("C", "A", 2010));
		
		//a)
		System.out.println("Original: " + l);
		
		//b)
		Collections.sort(l);
		System.out.println("Standardreihenfolge: " + l);

		//c)
		Collections.sort(l, new Comparator<Person>() {
			public int compare(Person a, Person b) {
				int r = -(a.getGeburtsjahr() - b.getGeburtsjahr());
				if (r == 0) {
					return a.compareTo(b);
				}
				return r;
			}			
		});
		System.out.println("Alter desc, Name asc, Vorname asc: " + l);
		
		//d)
		Collections.shuffle(l);
		System.out.println("Shuffled: " + l);
		
		//e)
		System.out.println("Jüngster: " + Collections.min(l, new Comparator<Person>() {
			public int compare(Person a, Person b) {
				return -(a.getGeburtsjahr() - b.getGeburtsjahr());
			}			
		}));
		
		//e)
		System.out.println("Ältester: " + Collections.max(l, new Comparator<Person>() {
			public int compare(Person a, Person b) {
				return -(a.getGeburtsjahr() - b.getGeburtsjahr());
			}			
		}));
		
	}

}
