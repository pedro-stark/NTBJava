package src.Collections.u2_3_Collections_BulkOperations;

import java.util.*;
import java.util.function.*;

public class U38_A3 {

	public static void main(String[] args) {
		Person pErwachsen = new Person("Hans", 30);
		Person pKind = new Person("Anna", 5);
		
		//Predicate<Person> p18JahreOderAelter_V1 = ???; //als Lambda
		//Predicate<Person> p18JahreOderAelter_V2 = ???; //als Methodenreferenz
		
		//System.out.println(pErwachsen + " Erwachsen? " + p18JahreOderAelter_V1.test(pErwachsen) + "/" + p18JahreOderAelter_V2.test(pErwachsen));
		//System.out.println(pKind + " Erwachsen? " + p18JahreOderAelter_V1.test(pKind) + "/" + p18JahreOderAelter_V2.test(pKind));
	}

}
