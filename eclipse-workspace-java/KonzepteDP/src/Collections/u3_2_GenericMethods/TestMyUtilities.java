package Collections.u3_2_GenericMethods;

import java.util.*;

public class TestMyUtilities {

	public static void main(String[] args) {
		//2.1
		System.out.println("-------------2.1");

		Integer[] intArray = {1, 5, 9, 34, 2, 67}; //mit Autoboxing
		String[] strArray = {"Peter", "Hans", "Anna", "Carlo", "Elisabeth"}; 
		
		MyUtilities.print(intArray);
		MyUtilities.swap(intArray, 0, intArray.length - 1);
		MyUtilities.print(intArray);

		MyUtilities.print(strArray);
		MyUtilities.swap(strArray, 1, 2);
		MyUtilities.print(strArray);
		
		System.out.println("-------------end of 2.1\n");
		
		
		//2.2
		System.out.println("-------------2.2");

		List<Integer> intList = Arrays.asList(intArray);
		List<String> strList = Arrays.asList(strArray);
		
		System.out.println("Anzahl ungerader Zahlen: " + MyUtilities.count(intList, i -> i % 2 == 1));
		System.out.println("Anzahl Strings länger als 4: " + MyUtilities.count(strList, s -> s.length() > 4));

		System.out.println("-------------end of 2.2\n");
		
		//2.3
		System.out.println("-------------2.3");
		
		System.out.println("Grösstes Element: " + MyUtilities.max(intArray, 0, intArray.length));
		System.out.println("Grösstes Element: " + MyUtilities.max(strArray, 1, 4));
		
		System.out.println("-------------end of 2.3\n");
	}

}
