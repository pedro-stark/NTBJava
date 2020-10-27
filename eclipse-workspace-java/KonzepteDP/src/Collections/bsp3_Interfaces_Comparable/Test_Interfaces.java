package Collections.bsp3_Interfaces_Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Test_Interfaces {
	public static void main(String[] args) {
		Article_RawType a = new Article_RawType(1234, 50);
		Article_RawType b = new Article_RawType(9345, 10);
		Article_RawType c = new Article_RawType(2876, 25);
		
		ArrayList<Article_RawType> listOfAs = new ArrayList<Article_RawType>();
		listOfAs.add(a);
		listOfAs.add(b);
		listOfAs.add(c);
		
		System.out.println("Original " + listOfAs);
		
		System.out.println();
		
		Collections.sort(listOfAs);
		System.out.println("Sorted " + listOfAs);
		
	}
}
