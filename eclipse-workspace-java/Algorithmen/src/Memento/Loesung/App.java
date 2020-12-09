package Memento.Loesung;

public class App {

	public static void main(String[] args) {
		Person originator = new Person();
		Caretaker caretaker = new Caretaker();
		
		//saving state 1
		originator.setPerson("Mustermann","Hans",34);
		caretaker.addMemento(originator.save());
		printState(originator);
		
		//saving state 2
		originator.setPerson("Musterfrau", "Heike", 28);
		caretaker.addMemento(originator.save());
		printState(originator);
		
		//undo: Return to state 1
		//restore needs a memento which comes from the caretaker
		originator.restore(caretaker.undo());
		printState(originator);
		
		//redo: Return to state 2
		//restore needs a memento which comes from the caretaker
		originator.restore(caretaker.redo());
		printState(originator);
				
	}
	public static void printState(Person p){
		System.out.println("Current state: "+p.toString());
	}
}
