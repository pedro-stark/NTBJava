package Generics;

public class Grossvater {

	String name;
	
	public Grossvater() throws Exception{
		name = "Fritz";
	}
	
	public Grossvater(String n) {
		name = n;
	}
	
	public int compareTo(Grossvater v) {
		return v.getName().compareTo(name);
	}
	
	public String getName() {return name;}
	
	public String toString() {return name;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
