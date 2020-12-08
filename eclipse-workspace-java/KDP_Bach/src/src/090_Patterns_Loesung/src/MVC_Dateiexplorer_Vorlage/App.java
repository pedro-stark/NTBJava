package MVC_Dateiexplorer_Vorlage;
import java.util.Arrays;

import javax.swing.JFrame;
import MVC_3_JTable.v1.model.*;
import MVC_3_JTable.v1.view.*;

public class App {

	public static void main(String[] args) {
		//erzeuge Modell
		Directory d = new Directory("C:/");
		
		//erzeuge eine View und uebergebe Modell
		JFrame f;
		f= new DirectoryViewer(d, "Viewer 1");
		//f= new DirectoryViewer(d, "Viewer 2"); f.setLocation(700,  0);

	}
}
