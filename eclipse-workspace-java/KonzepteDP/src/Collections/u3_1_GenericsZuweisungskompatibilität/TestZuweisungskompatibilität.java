package Collections.u3_1_GenericsZuweisungskompatibilit�t;

import java.util.*;

public class TestZuweisungskompatibilit�t {
	
	public static void main(String[] args) {
		ArrayList<Fahrzeug> fuhrpark = new ArrayList<>();
		
		//1
		//boolean add(E e): 
		//Welche Bedeutung hat hier E? Wie wird der tatsächliche Typ für E definiert?
		//
		//E ist der Elementtyp und muss zuweisungskompatibel mit Fahrzeug sein. Definiert wird er bei der Deklaration
		//der Variablen fuhrpark auf Zeile 8
		//
		fuhrpark.add(new Fahrzeug());
		fuhrpark.add(new PKW());
		fuhrpark.add(new LKW());
		
		
		//2
		//boolean addAll(Collection<? extends E> c): 
		//Welche Parameter können für c übergeben werden? Erklären Sie den Typ von c genau! Was bedeutet das ??
		//
		//c muss zunächst zuweisungskompatibel zu Collection sein. Also alles was von Collection abgeleitet ist, geht!
		//
		Collection<Fahrzeug> alF = new ArrayList<>(); alF.add(new Fahrzeug()); alF.add(new PKW()); alF.add(new LKW());
		fuhrpark.addAll(alF);
		
		Collection<Fahrzeug> setF = new HashSet<>(); setF.add(new Fahrzeug()); setF.add(new PKW()); setF.add(new LKW());
		fuhrpark.addAll(setF);
		
		//Als Elementtyp der Collection geht alles was von Fahrzeug abgeleitet ist. Also ist auch eine Liste von PKWs möglich
		Collection<PKW> alP = new ArrayList<>(); alP.add(new PKW());
		fuhrpark.addAll(alP);
		
		
		//3
		//void sort(Comparator<? super E> c) : 
		//Welche Parameter können für c übergeben werden? Was ist der Unterschied zwischen super und extends (Aufgabe davor)?
		//
		//Der Comparator muss Fahrzeuge vergleichen koennen: d.h. der Comparator muss auf Fahrzeug oder auf Oberklassen von
		//Fahrzeug (Bewegungsmittel oder Object) definiert sein.
		//
		
		//hier mit anonymer Klasse: beachte: Fahrzeug als Typ
		fuhrpark.sort(new Comparator<Fahrzeug>() {
			public int compare(Fahrzeug f1, Fahrzeug f2) {
				//todo; fuer die Erklaerung unwichtig
				return 0;
			}
		});

		//hier mit anonymer Klasse: beachte: Bewegungsmittel als Typ
		fuhrpark.sort(new Comparator<Bewegungsmittel>() {
			public int compare(Bewegungsmittel b1, Bewegungsmittel b2) {
				//todo; fuer die Erklaerung unwichtig
				return 0;
			}
		});
		//oder auch mit Lambda-Expression: beachte: Bewegungsmittel als Typ
		fuhrpark.sort((Bewegungsmittel b1, Bewegungsmittel b2) -> { /* todo */ return 0;});
		
		
		//4
		//void forEach(Consumer<? super E> action): 
		//Welche Parameter können für action übergeben werden? 
		//->Antwort dito wie bei Aufgabe 3
		//Consumer definiert eine Methode void accept(T t). Also muss eine Methode (z.B. als Lambda-Expression)
		//uebergeben werden, die ein Fahrzeug als Parameter uebernehmen kann
		fuhrpark.forEach(e -> e.doSomething(e)); //als klassische Lambda-Expression
		fuhrpark.forEach(e -> System.out.println(e)); //als klassische Lambda-Expression
		fuhrpark.forEach(System.out::println); //als Methodenreferenz
	
	}

}
