package src.CollectionsLoesung.bsp6_Generics_BoundedTypes;

public class Test_1_GenericBox {

	public static void main(String[] args) {
		//eine Box für Strings; ok: String implements Comparable<String>
		BoxForComparables<String> b1 = new BoxForComparables<>("Hallo");
		System.out.println(b1.unbox());
		
		//eine Box für Article - Compilerfehler!
		//BoxForComparables<Article> b3 = new BoxForComparables<>();
		
		//eine Box für Article
		BoxForComparables<Article_WithComparable> b2 = new BoxForComparables<>();		
		b2.box(new Article_WithComparable(1234, 50));
		System.out.println(b2.unbox());		
	}

}
