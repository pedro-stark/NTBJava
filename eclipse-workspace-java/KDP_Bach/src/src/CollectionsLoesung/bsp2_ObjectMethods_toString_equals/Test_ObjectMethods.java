package src.CollectionsLoesung.bsp2_ObjectMethods_toString_equals;

import java.util.*;

public class Test_ObjectMethods {
	
	public static void main(String[] args) {
		System.out.println("\ntoString");
		
		//ohne toString
		Article1 a1_a = new Article1(1234, 50);
		System.out.println(a1_a);

		//mit toString
		Article2 a2_a = new Article2(1234, 50);
		System.out.println(a2_a);
	

		/////////////////////////////////////////////////////////////
	
		System.out.println("\nequals");

		//equals
		Article2 a2_b = new Article2(1234, 50);
		System.out.println("Vergleich Article2 mit ==: " + (a2_a == a2_b));
		System.out.println("Vergleich Article2 mit equals: " + (a2_a.equals(a2_b)));

		System.out.println();
		Article3 a3_a = new Article3(1234, 50);
		Article3 a3_b = new Article3(1234, 50);
		System.out.println("Vergleich Article3 mit ==: " + (a3_a == a3_b));
		System.out.println("Vergleich Article3 mit equals: " + (a3_a.equals(a3_b)));
		System.out.println("Vergleich Article3 mit equals: " + (a3_b.equals(a3_a)));

		/////////////////////////////////////////////////////////////
		System.out.println("\nCollections of Article2");
		ArrayList<Article2> listOfA2s = new ArrayList<Article2>();
		listOfA2s.add(a2_a);
		listOfA2s.add(a2_b);
		
		System.out.println("listOfA2s contains a2_a? " + listOfA2s.contains(a2_a));

		Article2 a2_c = new Article2(1234, 50);
		System.out.println("listOfA2s contains a2_c? " + listOfA2s.contains(a2_c));
		
		
		/////////////////////////////////////////////////////////////
		System.out.println("\nCollections of Article3");
		
		ArrayList<Article3> listOfA3s = new ArrayList<Article3>();
		listOfA3s.add(a3_a);
		listOfA3s.add(a3_b);
		
		System.out.println("listOfA3s contains a3_a? " + listOfA3s.contains(a3_a));

		Article3 a3_c = new Article3(1234, 50);
		System.out.println("listOfA3s contains a3_c? " + listOfA3s.contains(a3_c));
	}
	
}
