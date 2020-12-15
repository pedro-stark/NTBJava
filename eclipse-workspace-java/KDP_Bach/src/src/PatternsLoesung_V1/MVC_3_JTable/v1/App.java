package src.PatternsLoesung_V1.MVC_3_JTable.v1;
import java.util.Arrays;

import javax.swing.JFrame;
import src.PatternsLoesung_V1.MVC_3_JTable.v1.model.*;
import src.PatternsLoesung_V1.MVC_3_JTable.v1.view.*;

public class App {

	public static void main(String[] args) {
		//erzeuge Modell
		Personenliste pliste = new Personenliste();
		Person p = new Person("Mueller", "Bernhard", 40);
		pliste.add(p);
		System.out.println("nach Erzeugung des Modells:" + pliste);
		
		//erzeuge eine View und uebergebe Modell
		JFrame f;
		f= new MyWindow_JTable(pliste, "Fenster 1");
		f= new MyWindow_JTable(pliste, "Fenster 2"); f.setLocation(700,  0);

		System.out.println("modifiziere Modell:" + pliste);
		pliste.add(new Person("Mueller", "Hans", 50));
		pliste.add(new Person("Schmid", "Anna", 30));
		
		System.out.println("modifiziere Modell:" + pliste);
		pliste.remove(p);
	}
}
