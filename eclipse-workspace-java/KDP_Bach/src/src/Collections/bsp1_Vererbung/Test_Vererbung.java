package src.Collections.bsp1_Vererbung;

public class Test_Vererbung {

	public static void main(String[] args) {
		
		Article a = new Article(4711, 50);
		System.out.println("Available? " +a.available());
		a.print();
		System.out.println("\ncode: " + a.code);
		
		System.out.println("-------------------------------");
		
		Book b = new Book(4712, 30, "Mueller", "Vererbung");
		System.out.println("Available? " +b.available());
		b.print();
		System.out.println("\nAuthor: " + b.author);
		
	}

}
