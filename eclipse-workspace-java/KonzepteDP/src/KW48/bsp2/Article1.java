package KW48.bsp2;

//Nach Moessenboeck

public class Article1 {
	
	public int code;
	public int price;
	
	public Article1(int c, int p) {
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


