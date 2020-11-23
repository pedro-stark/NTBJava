/*ToDo
 * 1. in "Gruss" extrinsic und intrinsic ausfindig machen
 * 2. in "Interface_Flyweight" die Methode anpassen --> extrinsic state als Argument
 * 3. in "Gruss" das Interface implementieren
 * 4. in "Flyweightfactory" in der Methode getFlyweights ist das Flyweight zu erstellen
 * 5. in "Client" flyweight nutzen
 * 	  Falls die Zeit knapp wird, kann das Flyweight auch nur mit einem extrinsic state aufgerufen werden
 */

package Flyweight.Loesung;

public class Client {
	Gruss[] gruesse;
	
	public static void main(String[] args) {
		Client c = new Client();
	}
	
	public Client() {
		gruesse = new Gruss[5];
		FlyweightFactory factory = new FlyweightFactory();
		
		gruesse[0] = factory.getFlyweights("gruss"); //<-- erstellung
		gruesse[1] = factory.getFlyweights("gruss"); //<-- wiederverwendung
		gruesse[2] = factory.getFlyweights("gruss"); //<-- wiederverwendung
		gruesse[3] = factory.getFlyweights("gruss"); //<-- wiederverwendung
		gruesse[4] = factory.getFlyweights("gruss"); //<-- wiederverwendung
		
		printAll();
	}
	
	public void printAll() {
		System.out.println("--------------------------");
		gruesse[0].print("Herr Maier", "Holzbau AG", "Max Mustermann");
		System.out.println("--------------------------");
		gruesse[1].print("Herr Müller", "Metallbau AG", "Hans Mustermann");
		System.out.println("--------------------------");
		gruesse[2].print("Frau Holz", "Büro AG", "Jürgen Mannmuster");
		System.out.println("--------------------------");
		gruesse[3].print("Frau Kühni", "Ihnen", "Donald Duck");
		System.out.println("--------------------------");
		gruesse[4].print("Herr Klass", "Chemie AG", "Walter Blanc");
		System.out.println("--------------------------");
	}
}


