package src.CollectionsLoesung.u3_1_GenericsZuweisungskompat;

import java.util.*;
import java.util.function.Consumer;

public class TestZuweisungskompatibilität {
	
	public static void main(String[] args) {
		ArrayList<Fahrzeug> fuhrpark = new ArrayList<>();
		
		//1
		//boolean add(E e): 
		//Welche Bedeutung hat hier E? Wie wird der tatsächliche Typ für E definiert?
		//
		//Welche Objekte können Sie dem Fuhrpark hinzufuegen: Bewegungsmittel?, Fahrzeug?, PKW?, LKW?
		//Ergänzen Sie alle möglichen Add (Hinweis 3 gehen):
		
		//E ist der Elementtyp, der der Liste hinzugefügt werden kann: Objekte des Typs E oder Ableitungen davon 
		fuhrpark.add(new Fahrzeug()); //Fahrzeug == E
		fuhrpark.add(new PKW()); //PWK ist von Fahrzeug abgeleitet
		fuhrpark.add(new LKW()); //LKW ist von Fahrzeug abgeleitet
		//fuhrpark.add(new Bewegungsmittel()); //Bewegungsmittel ist eine Oberklasse von Fahrzeug!
		
		
		//-----------------------------------------------------------------------------------------------------------
		//2
		//boolean addAll(Collection<? extends E> c): 
		//Welche Parameter können für c übergeben werden? Erklären Sie den Typ von c genau! Was bedeutet das ??
		//
		//Kann eine ArrayList zugwiesen werden?
		//ArrayList<Fahrzeug> arraylistOfFahrzeug = new ArrayList<>(); //E == Fahrzeug
		Collection<Fahrzeug> arraylistOfFahrzeug = new ArrayList<>(); //E == Fahrzeug
		arraylistOfFahrzeug.add(new Fahrzeug());
		arraylistOfFahrzeug.add(new PKW());
		arraylistOfFahrzeug.add(new LKW());
		fuhrpark.addAll(arraylistOfFahrzeug); //<? extend E>, ? == Fahrzeug (Deklaration von arraylistOfFahrzeug), E == Fahrzeug (aus Deklaration fuhrpark)
		
		//Kann ein HashSet zugwiesen werden?
		Collection<Fahrzeug> setOfFahrzeug = new HashSet<>(); //E == Fahrzeug
		setOfFahrzeug.add(new Fahrzeug());
		setOfFahrzeug.add(new PKW());
		setOfFahrzeug.add(new LKW());
		fuhrpark.addAll(setOfFahrzeug); //<? extend E>, ? == Fahrzeug, E == Fahrzeug
		
		//gegeben ist eine Collection von PKWs. Welche Objekttypen können nun hinzugefügt werden?
		Collection<PKW> alP = new ArrayList<>(); //E == PKW 
		//alP.add(new Fahrzeug()); // Fahrzeug ist eine Oberklasse von PKW
		alP.add(new PKW()); 
		fuhrpark.addAll(alP); //<? extend E>, ? == PKW, E == Fahrzeug

		
		
		//-----------------------------------------------------------------------------------------------------------
		//3
		//void sort(Comparator<? super E> c) : 
		//Welche Parameter können für c übergeben werden? Was ist der Unterschied zwischen super und extends (Aufgabe davor)?
		//
		//Uebergeben Sie hier die möglichen Comparatoren! (2 sind möglich) (entweder als anonyme Klasse oder als Lambda-Expr)
		fuhrpark.sort(new Comparator<Fahrzeug>() {
			public int compare(Fahrzeug o1, Fahrzeug o2) {
				//für die Erklärung unwichtig
				return 0;
			}
		});
		//gefordert ist: Comparator<? super E> c, E == Fahrzeug (aus der Deklaration der Variablen ArrayList<Fahrzeug> fuhrpark
		//uebergeben wird: Comparator<Fahrzeug) -> "? super Fahrzeug" == Fahrzeug?. Für ? wird Fahrzeug eingesetzt, ok. 

		fuhrpark.sort(new Comparator<Bewegungsmittel>() {
			public int compare(Bewegungsmittel o1, Bewegungsmittel o2) {
				//für die Erklärung unwichtig
				return 0;
			}
		});
		//"? super E" ist ein lower bounded type; Mit "? super Fahrzeug" kann man für ? "Fahrzeug" oder eine Oberklasse davon verwenden. 
		//Bewegungsmittel ist eine Oberklasse von Fahrzeug. Und somit i.O.

		//mit Lambda-Expression
		fuhrpark.sort((Bewegungsmittel o1, Bewegungsmittel o2) -> o1.intInBewegungsmittel - o2.intInBewegungsmittel);
		fuhrpark.sort((Fahrzeug o1, Fahrzeug o2) -> o1.intInBewegungsmittel - o2.intInBewegungsmittel - o1.intInFahrzeug - o2.intInFahrzeug);
		
		fuhrpark.sort((o1, o2) -> o1.intInBewegungsmittel - o2.intInBewegungsmittel - o1.intInFahrzeug - o2.intInFahrzeug); 
			//Elementtyp von o1/o2 ist E, Fahrzeug!!!
		
		
		//-----------------------------------------------------------------------------------------------------------
		//4
		//void forEach(Consumer<? super E> action): 
		//Welche Parameter können für action übergeben werden?
		//
		//1a. Rufen Sie für jedes Element die Methode doSomething auf (als Anonyme Klasse)
		//1b. Rufen Sie für jedes Element die Methode doSomething auf (als Lambda)
		//2. geben Sie jedes Element mit System.out.println aus (als Lambda)
		//3. geben Sie jedes Element mit System.out.println aus (als Methodenreferenz)
		fuhrpark.forEach(new Consumer<Fahrzeug>() {
			public void accept(Fahrzeug t) {
				t.doSomething();
			}
		});
		fuhrpark.forEach(new Consumer<Bewegungsmittel>() {
			public void accept(Bewegungsmittel t) {
				t.doSomething();
			}
		});
		
		fuhrpark.forEach(t -> t.doSomething()); //Lambda-Expression
		
		fuhrpark.forEach(t -> System.out.println(t)); //Lambda-Expression
		
		fuhrpark.forEach(System.out::println); //Methodenreferenz
		
	
	}

}
