package Collections.bsp3_Interfaces_Comparable;

//
//Achtung: implements Comparable! (Raw-Type)
//beachte die andere Signatur der Comparable-Methode (Paramter vom Typ Object)
//

public class Article_RawType implements Comparable {
	
	public int code;
	public int price;
	
	public Article_RawType(int c, int p) {
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
		if (o instanceof Article_RawType) {
			Article_RawType a = (Article_RawType)o;
			return this.code == a.code && this.price == a.price;
		}
		return false;
	}

	public int compareTo(Object o) {
		//Sortieren nach preis
		//this < obj: <0; this == obj: 0, this > obj: >0
		if (o instanceof Article_RawType) {
			Article_RawType a = (Article_RawType)o;

			return price - a.price;
			//return a.code - code;
		}

		throw new IllegalArgumentException("Object of class ArticleV2 expected!");
	}

}



