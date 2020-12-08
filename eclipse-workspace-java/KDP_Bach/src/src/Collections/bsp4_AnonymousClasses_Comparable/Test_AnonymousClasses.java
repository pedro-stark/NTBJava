package src.Collections.bsp4_AnonymousClasses_Comparable;

import java.util.*;

public class Test_AnonymousClasses {
	public static void main(String[] args) {
		Article a = new Article(1234, 50);
		Article b = new Article(2345, 10);
		Article c = new Article(9876, 25);
		
		ArrayList<Article> listOfAs = new ArrayList<Article>();
		listOfAs.add(a);
		listOfAs.add(b);
		listOfAs.add(c);
		
		System.out.println("Original " + listOfAs);
		
		System.out.println();
		
		Collections.sort(listOfAs);
		System.out.println("Sorted (asc) " + listOfAs);

		System.out.println();

		Collections.sort(listOfAs, new ArticlePriceDescendingComparator());
		System.out.println("Sorted (desc) " + listOfAs);
		
		System.out.println();

		//mit Anonymer Klasse
		Collections.sort(listOfAs, 
			new Comparator<Article>() {		
				public int compare(Article a1, Article a2) {
					return a1.compareTo(a2);
				}
			}
		);
		System.out.println("Sorted 2 (asc) " + listOfAs);
	}
}
