package src.Collections.bsp6_Generics_BoundedTypes;

public class Test_2_GenericMethods {
	
	//generische Methode, die nur Typen T akzeptiert, die das Interface Comparable implementieren
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray) {
	        if (e.compareTo(elem) > 0) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		/*
		Article[] l = new Article[2]; l[0] = new Article(1234, 50); l[1] = new Article(4567, 50);
		System.out.println("Array  enthält " + countGreaterThan(l, new Article(2222, 25)) +
				" Elemente, die grösser sind.");
		*/
		Article_WithComparable[] l = new Article_WithComparable[2]; l[0] = new Article_WithComparable(1234, 50); l[1] = new Article_WithComparable(4567, 50);
		System.out.println("Array  enthält " + countGreaterThan(l, new Article_WithComparable(2222, 25)) +
				" Elemente, die grösser sind.");

		
		Integer[] a = {20, 1, 34, 45, 9};
		
		System.out.println("Array {20, 1, 34, 45, 9} enthält " + countGreaterThan(a, 9) +
				" Elemente, die grösser als 9 sind.");
		

		
		String[] s = {"Meier", "Müller", "Bach", "Schmid"};
		
		System.out.println("Array {\"Meier\", \"Müller\", \"Bach\", \"Schmid\"} enthält " + countGreaterThan(s, "Mi") +
				" Elemente, die grösser als \"Mi\" sind.");

	}

}
