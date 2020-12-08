package src.ExceptionsLoesung.uebungen;
import java.util.Arrays;

public class Aufgabe2_Date {
	private int day;
	private String month;
	private int year;
	
	public Aufgabe2_Date(int _day, String _month, int _year) /* kein throws nötig! */ {
		//IllegalArgumentException ist von RuntimeException abgeleitet und muss daher 
		//nicht mit throws deklariert werden!
		
		if (_day < 31 && _day >0){
			day = _day;
		} else {
			throw new IllegalArgumentException("Day is not in Range");
		}
		if (_year > 0){
			year = _year;
		} else {
			throw new IllegalArgumentException("Year can not be negativ");
		}
		
		month = _month;
	}
	
	public String toString() {
		return "" + day + " " + month + " " + year;
	}
	
	
	public static void main(String[] args) {
		Aufgabe2_Date a;
		
		a = new Aufgabe2_Date(1, "Jan", 1);
		System.out.println("0: " + a); //ok
		
		//IllegalArgumentException ist von RuntimeException abgeleitet und muss daher 
		//nicht abgefangen werden!
		
		//kann abgefangen werden
		a = null;
		try {
			a = new Aufgabe2_Date(0, "Jan", 1);
			System.out.println("1: " + a); //ungültiger Tag
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}		
		System.out.println("2: " + a); //ungültiger Tag
		
		//muss aber nicht
		System.out.println(new Aufgabe2_Date(1, "Jan", -1000)); //ungültiges Jahr
	}
}
