package src.Collections.bsp3_Interfaces_Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Test_Interfaces_MitGenerics {
	public static void main(String[] args) {
		Article a = new Article(1234, 50);
		Article b = new Article(9345, 10);
		Article c = new Article(2876, 25);
		
		ArrayList<Article> listOfAs = new ArrayList<Article>();
		listOfAs.add(a);
		listOfAs.add(b);
		listOfAs.add(c);
		
		System.out.println("Original " + listOfAs);
		
		System.out.println();
		
		Collections.sort(listOfAs);
		System.out.println("Sorted " + listOfAs);
		
	}
}
