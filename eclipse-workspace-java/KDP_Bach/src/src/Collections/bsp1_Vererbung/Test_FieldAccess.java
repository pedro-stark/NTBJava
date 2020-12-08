package src.Collections.bsp1_Vererbung;

public class Test_FieldAccess {

	public static void main(String[] args) {
		Article a = new Book(1234, 50, "May", "Winnetou");
		a = new Audio(1234, 50, "May", 23);
		
		int i; String s; boolean bb;
		i = a.code;
		i = a.price;
		bb = a.available();
		a.print();
		//s = a.author; //Compile error: statischer Typ von a ist Article
		
		
		//Laufzeittest auf Klassenzugehörigkeit
		if (a instanceof Book) {
			Book b = (Book)a; //Type-Cast
			
			i = b.code;
			i = b.price;
			s = b.author;
			s = b.title;
		}
	}

}
