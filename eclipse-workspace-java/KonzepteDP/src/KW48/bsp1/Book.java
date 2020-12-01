package KW48.bsp1;

public class Book extends Article {
	public String author;
	public String title;
	
	public Book(int c, int p, String a, String t) {
		super(c, p);
		author = a;
		title = t;
	}
	
	public void print() {
		super.print();
		System.out.println("...Book: " + author + " " + title);
	}
}
