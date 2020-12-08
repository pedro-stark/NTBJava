package src.Collections.u2_1_Lambdas_Inden;

import java.util.*;

public class U_Kap27_A1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//traditionell mit einer Instanz einer Klasse
		LongBinaryOperator v00 = new MyLongBinaryOperator();
		System.out.println("Ausgabe mit v00: " + v00.applyAsLong(3L, 5L));
		
		//traditionell mit einer anonymen Klasse
		LongBinaryOperator v01 = new LongBinaryOperator() {
			public long applyAsLong(final long left, final long right) {
				return left + right;
			}
		};
		System.out.println("Ausgabe mit v01: " + v01.applyAsLong(3L, 5L));
		
		//
		// und nun die Beispiele 
		//
		
		//final LongBinaryOperator v1 = (long x, Long y) -> { return x + y; };

		//Achtung: 2. Parameter Klasse Long nicht Basisdatentyp long
		//unboxing des zweiten Parameters klappt nicht
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
		listOfIntegers.add(new Integer(4711));
		//was ist Boxing? z.B. Umwandlung von int i in ein Integer-Objekt
		listOfIntegers.add(4712); //boxing
		//was ist Unboxing? Umwandlung eines Integer-Objekts in einen Basisdatentyp int
		int i = listOfIntegers.get(0); //unboxing 
		
		
		//ok: Langschreibweise
		LongBinaryOperator v2 = (long x, long y) -> { return x + y; };
		System.out.println("Ausgabe mit v2: " + v2.applyAsLong(3L, 5L));
		
		//
		//TODO: die weiteren Zeilen aus der Uebung
		//
	}
}
