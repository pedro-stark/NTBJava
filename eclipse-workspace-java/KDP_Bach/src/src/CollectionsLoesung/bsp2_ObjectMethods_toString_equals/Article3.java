package src.CollectionsLoesung.bsp2_ObjectMethods_toString_equals;

//Nach Moessenboeck

public class Article3 {
	
	public int code;
	public int price;
	
	public Article3(int c, int p) {
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
		return this.getClass() + " " + code + " price: " + price + " ";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Article3) {
			Article3 a = (Article3)o;
			
			return this.code == a.code && this.price == a.price;
		}
		return false;
	}
	
	public int hashCode() {
		//see Doku zu hashCode: Objekete, bei denen equals true liefert, müssen den gleichen Hashcode haben
		return 1<<16*code + price;
	}
	
}



