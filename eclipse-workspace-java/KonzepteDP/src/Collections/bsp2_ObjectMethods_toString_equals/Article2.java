package Collections.bsp2_ObjectMethods_toString_equals;

//Nach Moessenboeck

public class Article2 {
	
	public int code;
	public int price;
	
	public Article2(int c, int p) {
		code = c;
		price = p;
	}
	
	public boolean available() { 
		return true; 
	}
	
	public void print() {
		System.out.print("Article: " + code + " price: " + price + " ");
	}
	
	public String toString() {
		return this.getClass().getName() + " " + code + " price: " + price + " ";
	}
	
}



