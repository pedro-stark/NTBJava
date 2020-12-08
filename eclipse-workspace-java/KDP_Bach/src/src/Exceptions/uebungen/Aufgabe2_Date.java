package src.Exceptions.uebungen;
import java.util.Arrays;

public class Aufgabe2_Date {
	private int day;
	private String month;
	private int year;
	
	public Aufgabe2_Date(int _day, String _month, int _year) {
		//Wenn das Datum nicht gültig ist, soll eine IllegalArgumentException  
		//geworfen werden.
		//Warum muss kein "throws IllegalArgumentException" in der Signatur stehen? 
		
		//TODO
	}
	
	public String toString() {
		return "" + day + " " + month + " " + year;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(new Aufgabe2_Date(1, "Jan", 1)); //ok
		
		//IllegalArgumentException kann abgefangen werden
		try {
			System.out.println(new Aufgabe2_Date(55, "Jan", 1)); //ungültiger Tag
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		//muss aber nicht! (warum?)
		System.out.println(new Aufgabe2_Date(1, "Jan", -1000)); //ungültiges Jahr
	}
}
