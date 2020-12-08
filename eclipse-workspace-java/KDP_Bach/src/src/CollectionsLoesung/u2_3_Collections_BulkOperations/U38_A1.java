package src.CollectionsLoesung.u2_3_Collections_BulkOperations;

import java.util.*;

public class U38_A1 {

	public static void main(String[] args) {
		final List<String> names = Arrays.asList("Tim", "Peter", "Mike");
		
		//externe Iteration
		for (String name : names) { 
			System.out.println(name); 
		}
		
		//und nun interne Iteration
		System.out.println("mit interner Iteration und Methodenreferenz"); 
		names.forEach(System.out::println); //z.B. mit einer Methodenreferenz

		System.out.println("mit interner Iteration und Lambda-Expression"); 
		names.forEach(e -> System.out.println(e)); //z.B. mit einer Methodenreferenz
	}

}
