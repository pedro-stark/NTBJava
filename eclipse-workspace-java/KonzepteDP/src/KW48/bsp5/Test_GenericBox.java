package KW48.bsp5;

public class Test_GenericBox {

	public static void main(String[] args) {
		//eine Box für Strings
		Box<String> b1 = new Box<>("Hallo");
		System.out.println(b1.unbox());
		System.out.println(b1);
		
		//eine Box für Article
		Box<Article> b2 = new Box<>();
		b2.box(new Article(1234, 50));
		System.out.println(b2.unbox());
		System.out.println(b2);
		
		//eine Box für Integer
		Box<Integer> b3 = new Box<>();
		b3.box(new Integer(4711));
		b3.box(4711); //autoboxing
		System.out.println(b3.unbox());
		System.out.println(b3);
		
		//Achtung: Verwendung der Box als Raw-Type (siehe Warnung)
		Box b4 = new Box();
		
		
	}

}
