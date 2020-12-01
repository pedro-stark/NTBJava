package KW48.u2_3;

import java.util.*;

public class U38_A1 {

	public static void main(String[] args) {
		final List<String> names = Arrays.asList("Tim", "Peter", "Mike");
		for (String name : names) { 
			System.out.println(name); 
		}
		
		//und nun interne Iteration
		System.out.println("mit interner Iteration"); 
		names.forEach(System.out::println); //z.B. mit einer Methodenreferenz
	}

}
