package KW48.bsp6;

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
	
	public String toString() {
		return "Article: code: " + code + " price: " + price;
	}
	
}


