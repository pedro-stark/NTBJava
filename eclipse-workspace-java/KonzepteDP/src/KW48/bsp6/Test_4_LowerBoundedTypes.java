package KW48.bsp6;

import java.util.*;

public class Test_4_LowerBoundedTypes {

	//https://docs.oracle.com/javase/tutorial/java/generics/lowerBounded.html
	
	public static void addNumbers_0(List<Integer> list) {
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	}

	public static void addNumbers_1(List<? super Integer> list) {
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	}
	
	
	public static void main(String[] args) {
		List<Number> listOfNumbers = new ArrayList<>(Arrays.asList(1, 2.5, 3.1));
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1, 2, 3));

		addNumbers_0(listOfIntegers); System.out.println(listOfIntegers);
		//addNumbers_0(listOfNumbers); //Compile error: List<Number> not compatible mit List<Integer>

		addNumbers_1(listOfIntegers); System.out.println(listOfIntegers);
		addNumbers_1(listOfNumbers); System.out.println(listOfNumbers);
	}

}
