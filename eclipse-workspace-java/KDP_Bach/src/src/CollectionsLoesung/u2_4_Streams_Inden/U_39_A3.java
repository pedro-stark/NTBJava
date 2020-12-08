package src.CollectionsLoesung.u2_4_Streams_Inden;

import java.util.*;
import java.util.stream.*;

public class U_39_A3 {

	public static void main(String[] args) {
		String[] namesArray = { "Tim", "Tom", "Andy", "Mike", "Merten" };
		Stream<String> streamFromArray = Arrays.stream(namesArray);

		String joined = streamFromArray.collect(Collectors.joining(", "));
		System.out.println(joined);		
	}

}
