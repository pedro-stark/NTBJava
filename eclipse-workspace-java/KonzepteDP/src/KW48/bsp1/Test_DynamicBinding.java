package KW48.bsp1;

import java.util.*;

public class Test_DynamicBinding {

	public static void main(String[] args) {

		Article aa1 = new Book(1234, 50, "May", "Winnetou");
		aa1.print();
		System.out.println();

		Article aa2 = new Article(1234, 50);
		if (aa2 instanceof Book) {
			Book bb2 = (Book)aa2;
			bb2.print();
		} else {
			System.out.println("aa2 ist kein Book! sondern ein " + aa2.getClass().getName());
		}
		

		////////////////////////////////////////////
		System.out.println();
		////////////////////////////////////////////

		
		
		//mit Arrays
		Article[] a1 = new Article[3];
		
		a1[0] = new Book(1234, 50, "May", "Winnetou");
		a1[1] = new Audio(5678, 10, "Best of", 70);
		a1[2] = new Book(9999, 20, "Gonzalez", "All you want to know");
		
		for (int i = 0; i < a1.length; i++) {
			if (a1[i].available()) { //aus Article
				a1[i].print(); //dynamische Bindung
			}
		}
		
		////////////////////////////////////////////
		System.out.println();
		////////////////////////////////////////////
		
		//mit ArrayList
		ArrayList<Article> a2 = new ArrayList<Article>();
		
		a2.add(new Book(1234, 50, "May", "Winnetou"));
		a2.add(new Audio(5678, 10, "Best of", 70));
		a2.add(new Book(9999, 20, "Gonzalez", "All you want to know"));
		
		for (Article a : a2) {
			if (a.available()) { //aus Article
				a.print(); //dynamische Bindung
			}
		}
	}

}
