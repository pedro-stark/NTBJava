package src.CollectionsLoesung.u2_1_Lambdas_Inden;

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
		
		//LongBinaryOperator v1 = (long x, Long y) -> { return x + y; };
		//Achtung: 2. Parameter Klasse Long nicht Basisdatentyp long
		//unboxing des zweiten Parameters klappt nicht		
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
		listOfIntegers.add(new Integer(4711));
		listOfIntegers.add(4712); //boxing
		int i = listOfIntegers.get(0); //unboxing 
		
		//ok: Langschreibweise
		LongBinaryOperator v2 = (long x, long y) -> { return x + y; };
		System.out.println("Ausgabe mit v2: " + v2.applyAsLong(3L, 5L));
		
		//ok: Kurzschreibweise Body (ohne {} und return (ein Ausdruck) )
		LongBinaryOperator v3 = (long x, long y) -> x + y;
		System.out.println("v3: " + v3.applyAsLong(2L, 3L));
		
		//nok: entweder alle Parameter typisiert, oder keiner. Mischform nicht möglich
		//LongBinaryOperator v4 = (long x, y) -> x + y;
		
		//ok: Kurzschreibweise: ohne Typen, ohne Klammern im Body
		LongBinaryOperator v5 = (x, y) -> x + y;
		System.out.println("v5: " + v5.applyAsLong(2L, 3L));
		
		//nok: nur wenn ein Parameter da ist, geht es ohne Klammern
		//LongBinaryOperator v6 = x, y -> x + y;	}		
	}
}
