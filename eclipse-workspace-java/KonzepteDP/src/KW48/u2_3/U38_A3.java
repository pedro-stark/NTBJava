package KW48.u2_3;

import java.util.*;
import java.util.function.*;

public class U38_A3 {

	public static void main(String[] args) {
		Person pErwachsen = new Person("Hans", 30);
		Person pKind = new Person("Anna", 5);
		
		Predicate<Person> p18JahreOderAelter_V1 = p -> p.getAge() >= 18;
		Predicate<Person> p18JahreOderAelter_V2 = Person::isAdult;
		
		System.out.println(pErwachsen + " Erwachsen? " + p18JahreOderAelter_V1.test(pErwachsen) + "/" + p18JahreOderAelter_V2.test(pErwachsen));
		System.out.println(pKind + " Erwachsen? " + p18JahreOderAelter_V1.test(pKind) + "/" + p18JahreOderAelter_V2.test(pKind));
	}

}
