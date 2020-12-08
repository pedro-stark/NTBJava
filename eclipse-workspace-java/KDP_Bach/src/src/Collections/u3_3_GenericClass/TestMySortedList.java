package src.Collections.u3_3_GenericClass;

public class TestMySortedList {

	public static void main(String[] args) {
		MySortedList<Integer> liste1 = new MySortedList<>();
		liste1.add(4711); System.out.println(liste1); //expected [4711]
		liste1.add(100); System.out.println(liste1); //expected [100, 4711]
		liste1.add(9999); System.out.println(liste1); //expected [100, 4711, 9999]

		//------------------------------

		MySortedList<Person> liste2 = new MySortedList<>();
		
		Person p = new Person("Carlo", "Müller");
		liste2.add(p); 
		System.out.println(liste2); //expected [Müller]
		
		p = new Person("Peter", "Bach");
		liste2.add(p);  
		System.out.println(liste2); //expected [Bach, Müller]
		
		p.setNachname("Schmid"); 
		liste2.elementChanged(p);
		System.out.println(liste2); //expected [Müller, Schmid]
	}

}
