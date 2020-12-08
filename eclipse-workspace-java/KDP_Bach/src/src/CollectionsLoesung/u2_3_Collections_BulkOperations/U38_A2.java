package src.CollectionsLoesung.u2_3_Collections_BulkOperations;

import java.util.*;
import java.util.function.*;

public class U38_A2 {

	public static void main(String[] args) {
		// 2a
		Predicate<Integer> isEven = i -> i % 2 == 0; //i ist eigentlich Integer, wird dann ungeboxt int.
		Predicate<Integer> isNull = i -> i == 0;
		IntPredicate isPositive = i -> i >= 0; //Achtung: IntPredicate: optimiert, weil es kein unboxing ben�tigt

		for (int i = -3; i <= 3; i++) {
			System.out.println("" + i + " even? " + isEven.test(i) + " null? " + isNull.test(i) + " positive? "
					+ isPositive.test(i));
		}

		// 2b
		System.out.println();
		Predicate<String> isShortWord = s -> s.length() < 4;

		String[] woerter = { "der", "die", "das", "wieso", "weshalb", "warum" };
		for (String s : woerter) {
			System.out.println("isShort? " + s + " " + isShortWord.test(s));
		}
		

		// 2c
		System.out.println();
		Predicate<Integer> isPositive2 = i -> i >= 0;
		Predicate<Integer> isPositiveAndEven = isPositive2.and(isEven);
		Predicate<Integer> isPositiveAndUneven = isPositive2.and(isEven.negate());
		for (int i = -3; i <= 3; i++) {
			System.out.println("" + i + " positive and even? " + isPositiveAndEven.test(i) +
					" positive and uneven? " + isPositiveAndUneven.test(i));
		}
	}

}
