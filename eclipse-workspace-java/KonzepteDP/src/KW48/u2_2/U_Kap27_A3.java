package KW48.u2_2;

import java.util.*;

public class U_Kap27_A3 {

	public static void main(String[] args) {
		//Original gemäss Buch
		//Hinweis: final bedeutet, dass nur ein einziges Mal eine Zuweisung erfolgen kann. 
		//(Einige Programmierer sehen das als Möglichkeit den Code sicherer zu machen. 
		// Ich bin kein Fan davon.)
		//
		 List<String> names = Arrays.asList("Josef", "JÖrg", "Jürgen");
		
		 Comparator<String> byLength = new Comparator<String>() { 
			public int compare(String str1,  String str2) { 
				return Integer.compare(str1.length(), str2.length()); 
			} 
		}; 
			
		 Comparator<String> caseInsensitive = new Comparator<String>() { 
			public int compare(String str1,  String str2) { 
				return str1.compareToIgnoreCase(str2); 
			} 
		};
		
		Collections.sort(names, byLength); System.out.println(names);
		Collections.sort(names, caseInsensitive); System.out.println(names);
		
		
		//und nun mit Lambdas
		//a) mit einer lokalen Variablen
		Comparator<String> byLengthLambda = (str1,  str2) -> { return Integer.compare(str1.length(), str2.length()); }; 
		Collections.sort(names, byLengthLambda); System.out.println(names);
		
		//b) direkt inline
		Collections.sort(names, (str1,  str2) -> { return str1.compareToIgnoreCase(str2); }); 
		System.out.println(names);

	}
}
