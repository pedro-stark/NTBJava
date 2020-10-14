package Lektion4;

public class Liste {
	Elem head = null; // Referenz auf erstes Element
	Elem tail = null; // Referenz auf letztes Element
	int length = 0;

	public void append(Object o) { // Zeitkomplexit�t: O(1)
		Elem e = new Elem();
		e.data = o;

		if (head == null || tail == null) { // erstes Objekt abfangen
			head = e;
			tail = e;
			tail.next = null;
			head.prev = null;
			System.out.println("Objekt '" + head.data.toString() + "' wurde als 1. Objekt der Liste hinzugef�gt");
			length = 1;
		} else if (head.next == null || tail.prev == null) { // zweites Objekt abfangen, dass tail <--> head
			head.next = e; //nicht n�tig, da kein Spezialfall (siehe else)
			tail = e;
			tail.prev = head;
			System.out.println("Objekt '" + tail.data.toString() + "' wurde als 2. Objekt der Liste hinzugef�gt");
			length = 2;
		} else { // Alle F�lle, wenn Liste > 2
			tail.next = e;
			e.prev = tail;
			e.next = null;
			tail = e;
			length++;
			System.out.println(
					"Objekt '" + tail.data.toString() + "' wurde als " + length + ". Objekt der Liste hinzugef�gt");
		}
	}

	public void print() { // Zeitkomplexit�t: O(n)
		Elem p = head;
		int i = 1;

		while (p != null) {
			System.out.print("Listenobjekt Nummer " + i + " beinhaltet: ");
			System.out.println(p.data.toString());
			p = p.next;
			i++;
		}
	}

	public void insert(Object o) { // Zeitkomplexit�t: O(1)
									// Idee: Wie append() einfach umgekehrt
		Elem e = new Elem();
		e.data = o;

		if (head == null || tail == null) { // erstes Objekt abfangen
			head = e;
			tail = e;
			tail.next = null;
			head.prev = null;
			System.out.println("Objekt '" + head.data.toString() + "' wurde als 1. Objekt der Liste hinzugef�gt");
			length = 1;
		} else if (head.next == null || tail.prev == null) { // zweites Objekt abfangen, dass tail <--> head
			tail.prev = e; //nicht n�tig, da kein Spezialfall (siehe else)
			head = e;
			head.next = tail;
			System.out
					.println("Objekt '" + head.data.toString() + "' wurde als 2. Objekt am Kopf der Liste hinzugef�gt");
			length = 2;
		} else { // Alle F�lle, wenn Liste > 2
			head.prev = e;
			e.prev = null;
			e.next = head;
			head = e;
			length++;
			System.out.println("Objekt '" + head.data.toString() + "' wurde als " + length
					+ ". Objekt am Kopf der Liste hinzugef�gt");
		}
	}

	public void delete(Object o) { // Zeitkomplexit�t: O(n)

		System.out.println("Suche Objekt '" + o.toString() + "'");
		
		if (head.data == o) { //erstes Objekt?
			head = head.next;
			head.prev = null;
			length--;
		} else if (tail.data == o) { //letztes Objekt?
			tail = tail.prev;
			tail.next = null;
			length--;
		} else {  //irgendwas dazwischen
			Elem p = head;
			Elem q = null; 
			while (p.data != o) { //auch m�glich mit: while(p!=null && p.data==o) muss dann aber weiter unten abgefangen werden
				q = p;
				p = p.next;
				if (p.next == null) { //Abbruch, falls Elem nicht vorhanden in Liste
					System.out.println("Objekt '" + o.toString() + "' konnte nicht gefunden werden.");
					return;
				}
			}
			q.next = p.next;
			p.next.prev = q;
			length--;
		}
		System.out.println("Objekt '" + o.toString() + "' wurde von der Liste entfernt");
	}

	public void printBackwards() { // Zeitkomplexit�t: O(n)
		Elem p = tail; // Speicherkomplexit�t: O(1)
		int i = 1;
		while (p != null) {
			System.out.print("Backwardsprint " + i + ": ");
			System.out.println(p.data.toString());
			p = p.prev;
			i++;
		}
	}

	public int length() { // Zeitkomplexit�t: O(1)
		return length;
	}

	public boolean isEmpty() { // Zeitkomplexit�t: O(1)
		// Oder-Verkn�pfung nicht n�tig, wenn sauber gearbeitet
		return head == null || tail == null;  //oder return length == 0;
	}

	public boolean hasOneElement() { // Zeitkomplexit�t: O(1)
		// Oder-Verkn�pfung nicht n�tig, wenn sauber gearbeitet
		return (head != null && head.next == null) || (tail != null && tail.prev == null);
	}
}