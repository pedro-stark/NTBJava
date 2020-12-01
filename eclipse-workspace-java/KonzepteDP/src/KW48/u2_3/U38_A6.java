package KW48.u2_3;

import java.util.*;
import java.util.function.*;

public class U38_A6 {

	private static List<String> createNamesList() {
		List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Flo");
		names.add("Merten");
		return names;
	}

	private static List<String> removeIf_External_Iteration() {
		final List<String> names = createNamesList();
		final Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			final String currentName = it.next();
			if (currentName.length() < 4) {
				it.remove();
			}
		}
		return names;
	}

	private static List<String> replaceAll_External_Iteration() {
		List<String> names = createNamesList();
		ListIterator<String> it = names.listIterator();
		while (it.hasNext()) {
			final String currentName = it.next();
			if (currentName.startsWith("M")) {
				// set()-Methode aus ListIterator -> NACHLESEN!
				it.set(">>" + currentName.toUpperCase() + "<<");
			}
		}
		return names;
	}

	private static List<String> replaceAll_Internal_Iteration() {
		List<String> names = createNamesList();

		UnaryOperator<String> op = s -> s.startsWith("M") ? ">>" + s.toUpperCase() + "<<" : s;
		names.replaceAll(op);

		return names;
	}

	public static void main(String[] args) {
		System.out.println("Externe Iteration");
		replaceAll_External_Iteration().forEach(System.out::println);

		System.out.println();

		System.out.println("Interne Iteration");
		replaceAll_Internal_Iteration().forEach(System.out::println);

	}

}
