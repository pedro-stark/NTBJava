package Lektion3;

public class Liste {
	Elem head = null; // Referenz auf 1. Element

	public void append(Object o) {
		Elem e = new Elem();
		e.data = o;

		if (head == null) {
			head = e;
			System.out.println("Objekt '" + head.data.toString() + "' wurde als erstes Objekt der Liste hinzugefügt");
		} else {
			Elem p = head;
			Elem q = null;

			while (p != null) {
				q = p; // q hat immer den vorherigen Wert
				p = p.next;
			}
			q.next = e;
			System.out.println("Objekt '" + q.next.data.toString() + "' wurde der Liste hinzugefügt");
		}
	}

	public void print() { // Zeitkomplexität: O(n)
		Elem p = head;
		int i = 1;

		while (p != null) {
			System.out.print("Listenobjekt Nummer " + i + " beinhaltet: ");
			System.out.println(p.data.toString());
			p = p.next;
			i++;
		}
	}

	public void insert(Object o) { // Zeitkomplexität: O(1)
		Elem e = new Elem();
		e.data = o;

		if (head == null) {
			head = e;
			System.out.println("Objekt '" + head.data.toString() + "' wurde als erstes Objekt der Liste hinzugefügt");
		} else {
			e.next = head;
			head = e;
			System.out.println("Objekt '" + e.data.toString() + "' wurde an der Spitze der Liste hinzugefügt");
		}
	}

	public void delete(Object o) { // Zeitkomplexität: O(n)
		Elem p = head;
		Elem q = null;

		System.out.println("Suche Objekt '" + o.toString() + "'");

		while (p.data != o) { // TODO endlos-Loop abfangen, wenn Objekt nicht vorhanden , first und last object abfangen
			q = p;
			p = p.next;
		}
		q.next = p.next;
		System.out.println("Objekt '" + p.data.toString() + "' wurde von der Liste entfernt");
	}

	public void printBackwards() { // Zeitkomplexität: O(n)
		Elem p = head;			   // Speicherkomplexität: O(n)
		Liste l = new Liste();
		int i = 1;

		while (p != null) {
			l.insert(p.data);
			p = p.next;
		}

		p = l.head;
		while (p != null) {
			System.out.print("backwardsprint " + i + ": ");
			System.out.println(p.data.toString());
			p = p.next;
			i++;
		}
	}

	public int length() { // Zeitkomplexität: O(n)
		Elem p = head;
		int i = 0; // Zählt in while-Schlaufe eins zu hoch darum 0

		while (p != null) {
			p = p.next;
			i++;
		}
		return i;
	}

	public boolean isEmpty() { // Zeitkomplexität: O(1)
		boolean isEmpty;
		if (head == null) {
			isEmpty = true;
		} else {
			isEmpty = false;
		}
		return isEmpty;
		//Oder als Einzeiler: return head == null;
	}

	public boolean hasOneElement() { // Zeitkomplexität: O(1)
		boolean hasOneElement;
		if (head != null && head.next == null) { //Diese Anweisung zu drehen könnte zu einem Fehler führen
			hasOneElement = true;
		} else {
			hasOneElement = false;
		}
		return hasOneElement;
		//Oder als Einzeiler: return head != null && head.next == null;
	}
}