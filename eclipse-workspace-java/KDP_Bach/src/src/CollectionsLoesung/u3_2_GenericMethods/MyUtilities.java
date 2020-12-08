package src.CollectionsLoesung.u3_2_GenericMethods;

import java.util.*;
import java.util.function.*;

public class MyUtilities {

	//U2.1
	public static <T> void swap(T[] a, int p1, int p2) {
		T temp = a[p1];
		a[p1] = a[p2];
		a[p2] = temp;
	}
	
	//Eine generische Hilfsmethode
	public static <T> void print(T[] a) {
		for (T t : a) {
			System.out.print(t + ", ");
		}
		System.out.println();
	}

	
	
	//U2.2
	public static <T> int count(List<T> list, Predicate<T> predicate) {
		int count = 0;
		for (T t : list) {
			if (predicate.test(t)) {
				count++;
			}
		}
		return count;
	}

	//U2.3
	public static <T extends Comparable<? super T>> T max(T[] a, int from, int to) {
		T maxElt = a[from];
		for (int i = from; i < to; i++) {
			if (a[i].compareTo(maxElt) > 0) {
				maxElt = a[i];
			}
		}
		return maxElt;
	}

}
