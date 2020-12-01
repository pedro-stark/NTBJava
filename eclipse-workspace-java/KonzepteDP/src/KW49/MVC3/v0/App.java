package KW49.MVC3.v0;
import java.util.Arrays;

import javax.swing.JFrame;

import MVC_3_JTable.v0.model.Person;
import MVC_3_JTable.v0.model.Personenliste;
import MVC_3_JTable.v0.view.*;

public class App {

	public static void main(String[] args) {
		//erzeuge Modell
		Personenliste pliste = new Personenliste();
		pliste.add(new Person("Mueller", "Hans", 50));
		System.out.println("nach Erzeugung des Modells:" + pliste);
		
		//erzeuge eine View und uebergebe Modell
		JFrame f;
		f= new MyWindow_JTable(pliste, "Fenster 1");
		f= new MyWindow_JTable(pliste, "Fenster 2"); f.setLocation(700,  0);

		pliste.add(new Person("Mueller", "Bernhard", 40));
		//pliste.add(new Person("Mueller", "Hans", 9));
		pliste.add(new Person("Schmid", "Anna", 30));
		//pliste.add(new Person("Fink", "Sebastian", 1));
		System.out.println("nach Modellmodifikation:" + pliste);	
	}
}
