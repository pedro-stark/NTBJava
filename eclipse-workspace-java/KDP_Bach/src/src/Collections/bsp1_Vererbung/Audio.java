package src.Collections.bsp1_Vererbung;

public class Audio extends Article {
	public String title;
	public int length;
	
	public Audio(int c, int p, String t, int l) {
		super(c, p);
		title = t;
		length = l;
	}
	
	public void print() {
		super.print();
		System.out.println("...Audio: " + length + " " + title);
	}
}
