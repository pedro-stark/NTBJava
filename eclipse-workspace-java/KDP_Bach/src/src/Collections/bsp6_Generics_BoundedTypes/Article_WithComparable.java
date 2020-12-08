package src.Collections.bsp6_Generics_BoundedTypes;

public class Article_WithComparable implements Comparable<Article_WithComparable> {
	
	public int code;
	public int price;
	
	public Article_WithComparable(int c, int p) {
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
	
	public boolean equals(Object o) {
		if (o instanceof Article) {
			Article a = (Article)o;
			return this.code == a.code && this.price == a.price;
		}
		return false;
	}

	public int compareTo(Article_WithComparable a) {
		//Sortieren nach preis
		//this < obj: <0; this == obj: 0, this > obj: >0
		return price - a.price;
	}


}
