package src.CollectionsLoesung.u1_3_Set;

import java.util.*;

public class Mengenlehre {

	public static void main(String[] args) {
		
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 6, 8, 10, 12));
		
		System.out.println("A: " + a);
		System.out.println("B: " + b);

		//Schnittmenge
		Set<Integer> intersection = new HashSet<Integer>(a);
		intersection.retainAll(b);
		System.out.println("A intersect B: " + intersection);

		//Vereinigung
		Set<Integer> union = new HashSet<Integer>(a);
		union.addAll(b);
		System.out.println("A union B: " + union);
		
		//Differenz A-B
		Set<Integer> difference = new HashSet<Integer>(a);
		difference.removeAll(b);
		System.out.println("A - B: " + difference);
		
		//Ist t Teilmenge von a
		System.out.println("{1,2,3} Teilmenge von A? " + a.containsAll(Arrays.asList(1, 2, 3)));
	}

}
