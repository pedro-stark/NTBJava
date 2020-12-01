package KW48.u2_3;

import java.util.*;
import java.util.function.*;

public class U38_A5 {

	private static List<String> createNamesList() {
		List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Flo");
		names.add("Merten");
		return names;
	}

	private static List<String> removeIf_External_Iteration() {
		List<String> names = createNamesList();
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			final String currentName = it.next();
			if (currentName.length() < 4) {
				it.remove();
			}
		}
		return names;
	}

	//5a
	private static List<String> removeIf_Internal_Iteration() {
		List<String> names = createNamesList();
		names.removeIf(s -> s.length() < 4);
		return names;
	}

	//5b
	private static List<String> removeIf_Internal_Iteration(Predicate<String> p) {
		List<String> names = createNamesList();
		names.removeIf(p);
		return names;
	}

	public static void main(String[] args) {
		System.out.println("Externe Iteration");
		removeIf_External_Iteration().forEach(System.out::println);

		System.out.println();

		System.out.println("Interne Iteration 5a");
		removeIf_Internal_Iteration().forEach(System.out::println);

		System.out.println();

		System.out.println("Interne Iteration 5b");
		removeIf_Internal_Iteration(s -> s.length() < 4).forEach(System.out::println);
	}

}
