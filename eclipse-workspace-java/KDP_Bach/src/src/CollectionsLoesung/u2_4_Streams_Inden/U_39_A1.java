package src.CollectionsLoesung.u2_4_Streams_Inden;

import java.util.*;
import java.util.stream.*;

public class U_39_A1 {
	// 1a
	// - creation
	// - intermediate operation
	// - terminal

	public static void main(String[] args) {
		//1b
		String[] namesArray = { "Tim", "Tom", "Andy", "Mike", "Merten" };
		List<String> names = Arrays.asList(namesArray);
		
		Stream<String> streamFromArray = Arrays.stream(namesArray);
		Stream<String> streamFromList = names.stream();
		Stream<String> streamFromValues = Stream.of("Tim", "Tom", "Andy", "Mike", "Merten");
		
		
		//1c
		Stream<String> filtered =  streamFromList.filter(s -> s.startsWith("M"));
		Stream<String> mapped = streamFromValues.map(s -> s.toUpperCase());
		
		
		//1d
		System.out.println("filtered");
		filtered.forEach(System.out::println);

		System.out.println("\nmapped");
		mapped.forEach(System.out::println);
	}

}
