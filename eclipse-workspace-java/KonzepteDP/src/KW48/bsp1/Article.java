package KW48.bsp1;

//Nach Moessenboeck

public class Article {
	
	public int code;
	public int price;
	
	public Article(int c, int p) {
		code = c;
		price = p;
	}
	
	public boolean available() { 
		return true; 
	}
	
	public void print() {
		System.out.print("Article: " + code + " price: " + price + " ");
	}
	
}



