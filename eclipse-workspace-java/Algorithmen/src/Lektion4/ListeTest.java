package Lektion4;

public class ListeTest {
	public static void main(String[] args) {
		Liste l = new Liste();
		Object testObject = new Object();
		
		System.out.println("-------------- Test append --------------");
		l.append("abc1");
		l.append("abc2");
		l.append(testObject);
		l.append("abc3");
		l.append("abc4");
		l.append("abc5");
		l.append("abc6");
		System.out.println();
		
		System.out.println("-------------- Test print --------------");
		l.print(); //Gibt den Inhalt der Liste durch Aufrufen der Methode toString() der gespeicherten Objekte aus
		System.out.println();
		
		System.out.println("-------------- Test insert --------------");
		l.insert("abc0"); //fügt ein Objekt vorne ein
		l.print();
		System.out.println();
		
		System.out.println("-------------- Test delete, wenn Objekt vorhanden --------------");
		l.delete(testObject); //löscht ein Objekt o
		l.print();
		System.out.println();		
		System.out.println("-------------- Test delete, wenn Objekt nicht vorhanden --------------");
		l.delete("abc9");
		System.out.println();
		
		System.out.println("-------------- Test printBackwards --------------");
		l.printBackwards(); //Ausgabe rückwärts
		System.out.println();	
		
		System.out.println("-------------- Test length --------------");
		System.out.println("Länge der Liste: " + l.length()); //length() gibt zurück, wie viele Elemente die Liste beinhaltet
		System.out.println();	
		
		System.out.println("-------------- Test isEmpty --------------");
		System.out.println("Liste ist leer: " + l.isEmpty()); //gibt zurück, ob die Liste leer ist
		System.out.println();
		
		System.out.println("-------------- Test hasOneElement --------------");
		System.out.println("Liste '" + l.toString() + "' hat nur ein Element: " + l.hasOneElement());	//gibt zurück, ob die Liste nur ein Element beinhaltet
		Liste leer = new Liste();
		System.out.println("Liste '" + leer.toString() + "' hat nur ein Element: " + leer.hasOneElement());
		Liste einElem = new Liste();
		einElem.append("one");
		System.out.println("Liste '" + einElem.toString() + "' hat nur ein Element: " + einElem.hasOneElement());
		System.out.println();	
		
//		System.out.println("-------------- Test insert--------------");
//		Liste l2 = new Liste();
//		l2.insert("test1");
//		l2.insert("test2");
//		l2.insert("test3");
//		l2.insert("test4");
//		l2.print();
	}

}
