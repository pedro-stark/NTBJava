package Lektion3;

public class ListeTest {
	public static void main(String[] args) {
		Liste l = new Liste();
		Object testObject = new Object();
		
		System.out.println("------- Test append -------");
		l.append("abc1");
		l.append("abc2");
		l.append(testObject);
		l.append("abc3");
		l.append("abc4");
		l.append("abc5");
		l.append("abc6");
		System.out.println();
		
		System.out.println("------- Test print -------");
		l.print(); //Gibt den Inhalt der Liste durch Aufrufen der Methode toString() der gespeicherten Objekte aus
		System.out.println();
		
		System.out.println("------- Test insert -------");
		l.insert("abc0"); //f�gt ein Objekt vorne ein
		l.print();
		System.out.println();
		
		System.out.println("------- Test delete -------");
		l.delete(testObject); //l�scht ein Objekt o
		l.print();
		System.out.println();		
		
		System.out.println("------- Test printBackwards -------");
		l.printBackwards(); //Ausgabe r�ckw�rts
		System.out.println();	
		
		System.out.println("------- Test length -------");
		System.out.println("L�nge der Liste: " + l.length()); //length() gibt zur�ck, wie viele Elemente die Liste beinhaltet
		System.out.println();	
		
		System.out.println("------- Test isEmpty -------");
		System.out.println("Liste ist leer: " + l.isEmpty()); //gibt zur�ck, ob die Liste leer ist
		System.out.println();
		
		System.out.println("------- Test hasOneElement -------");
		System.out.println("Liste hat nur ein Element: " + l.hasOneElement());	//gibt zur�ck, ob die Liste nur ein Element beinhaltet
		System.out.println();	
	}

}
