package KW48.bsp1;

public class Test_FieldAccess {

	public static void main(String[] args) {
		Article a = new Book(1234, 50, "May", "Winnetou");

		int i; String s;
		i = a.code;
		i = a.price;
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
