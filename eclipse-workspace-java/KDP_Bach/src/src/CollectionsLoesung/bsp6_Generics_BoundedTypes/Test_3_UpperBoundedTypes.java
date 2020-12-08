package src.CollectionsLoesung.bsp6_Generics_BoundedTypes;

import java.util.*;

public class Test_3_UpperBoundedTypes {
	/*
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html
	 * Number kennt als Unterklassen z.B. alle Wrapper der Zahlenbasistypen (Integer, Double, ...)
	 * 
	 */
	
	
	public static double sum_0(List<Number> list) {
		//Kann nur List<Number> verarbeiten
		double sum = 0.0;
	    for (Number elem : list) {
	    	sum += elem.doubleValue();
	    }
	    return sum;
	}

	public static double sum_1(List<? extends Number> list) {
		//Kann List<Number>, List<Integer>, ... verarbeiten
		double sum = 0.0;
	    for (Number elem : list) {
	    	sum += elem.doubleValue();
	    }
	    return sum;
	}


	public static void main(String[] args) {
		List<Number> listOfNumbers = Arrays.asList(1, 2.5, 3.1);
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3);

		//sum_0
		System.out.println("Sum_0: " + sum_0(listOfNumbers));
		//System.out.println("Sum_0: " + sum_0(listOfIntegers)); //compile error: List<Integer> !isa List<Number>
		
		System.out.println("Sum_1: " + sum_1(listOfNumbers));
		System.out.println("Sum_1: " + sum_1(listOfIntegers));
	}
}
