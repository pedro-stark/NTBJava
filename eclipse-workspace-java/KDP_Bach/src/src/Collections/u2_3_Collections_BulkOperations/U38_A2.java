package src.Collections.u2_3_Collections_BulkOperations;

import java.util.*;
import java.util.function.*;

public class U38_A2 {

	public static void main(String[] args) {
		// 2a
		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isNull = ???;
		IntPredicate isPositive = ???;

		for (int i = -3; i <= 3; i++) {
			System.out.println("" + i + " even? " + isEven.test(i) + " null? " + isNull.test(i) + " positive? "
					+ isPositive.test(i));
		}

		// 2b
		System.out.println();
		Predicate<String> isShortWord = ???;

		String[] woerter = { "der", "die", "das", "wieso", "weshalb", "warum" };
		for (String s : woerter) {
			System.out.println("isShort? " + s + " " + isShortWord.test(s));
		}

		// 2c
		System.out.println();
		Predicate<Integer> isPositive2 = i -> i >= 0;
		Predicate<Integer> isPositiveAndEven = ???;
		Predicate<Integer> isPositiveAndUneven = ???;
		for (int i = -3; i <= 3; i++) {
			System.out.println("" + i + " positive and even? " + isPositiveAndEven.test(i) +
					" positive and uneven? " + isPositiveAndUneven.test(i));
		}
	}

}
