/*ToDo
 * 1. in "Gruss" extrinsic und intrinsic ausfindig machen
 * 2. in "Interface_Flyweight" die Methode anpassen --> extrinsic state als Argument
 * 3. in "Gruss" das Interface implementieren
 * 4. in "Flyweightfactory" in der Methode getFlyweights ist das Flyweight zu erstellen
 * 5. in "Client" flyweight nutzen
 * 	  Falls die Zeit knapp wird, kann das Flyweight auch nur mit einem extrinsic state aufgerufen werden
 */

package Flyweight.Uebung;

public class Client {
	Gruss[] gruesse;
	
	public static void main(String[] args) {
		Client c = new Client();
	}
	
	public Client() {
		gruesse = new Gruss[5];
		
		
		//---------------- für diesen Teil das Flyweight implementieren
		//momentan hat es für 5 Grüsse 5 verschiedene Objekte
		//--> Ziel ist nur ein Objekt im Speicher zu haben....
		gruesse[0] = new Gruss();
		gruesse[0].line1 = "Sehr geehrter Herr Maier";
		gruesse[0].line3 = "Wir bedanken uns bei Holzbau AG für das entgegengebrachte ";
		gruesse[0].line12 = "Max Mustermann";
		
		gruesse[1] = new Gruss();
		gruesse[1].line1 = "Sehr geehrter Herr Müller";
		gruesse[1].line3 = "Wir bedanken uns bei Metallbau AG für das entgegengebrachte ";
		gruesse[1].line12 = "Hans Mustermann";
		
		gruesse[2] = new Gruss();
		gruesse[2].line1 = "Sehr geehrter Frau Holz";
		gruesse[2].line3 = "Wir bedanken uns bei Büro AG für das entgegengebrachte ";
		gruesse[2].line12 = "Jürgen Mannmuster";
		
		gruesse[3] = new Gruss();
		gruesse[3].line1 = "Sehr geehrter Frau Kühni";
		gruesse[3].line3 = "Wir bedanken uns bei Ihnen für das entgegengebrachte ";
		gruesse[3].line12 = "Donald Duck";
		
		gruesse[4] = new Gruss();
		gruesse[4].line1 = "Sehr geehrter Herr Klass";
		gruesse[4].line3 = "Wir bedanken uns bei Chemie AG für das entgegengebrachte ";
		gruesse[4].line12 = "Walter Blanc";
		//----------------
		
		printAll(); //entweder diese Methode anpassen oder direkt hier die Flyweight aufrufe machen...
	}
	
	public void printAll() {
		for(Gruss g : gruesse) {
			System.out.println("---------------------------");
			g.print();
			System.out.println("---------------------------");
		}
	}
}


