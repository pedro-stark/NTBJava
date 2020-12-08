package src.Collections.bsp4_AnonymousClasses_Comparable;

public class Article implements Comparable<Article> {
	
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
	
	public String toString() {
		return this.getClass() + " " + code + " price: " + price + " ";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Article) {
			Article a = (Article)o;
			
			return this.code == a.code && this.price == a.price;
		}
		return false;
	}

	public int compareTo(Article a) {
		//Sortieren nach preis
		//this < obj: <0; this == obj: 0, this > obj: >0
		return price - a.price;
	}
	
}



