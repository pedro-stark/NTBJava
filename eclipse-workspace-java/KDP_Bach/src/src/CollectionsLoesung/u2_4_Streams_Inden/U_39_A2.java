package src.CollectionsLoesung.u2_4_Streams_Inden;

import java.util.*;
import java.util.stream.*;

public class U_39_A2 {

	public static void main(String[] args) {
		String[] namesArray = { "Tim", "Tom", "Andy", "Mike", "Merten" };
		
		Stream<String> streamFromArray = Arrays.stream(namesArray);
		Stream<String> streamFromValues = Stream.of("Tim", "Tom", "Andy", "Mike", "Merten");

		
		Object[] contentsAsArray = streamFromArray.toArray();
		List<String> contentsAsList = streamFromValues.collect(Collectors.toList());
	}

}
