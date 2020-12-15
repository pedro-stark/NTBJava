package src.PatternsLoesung_V1.MVC_Dateiexplorer;
import java.util.Arrays;

import javax.swing.JFrame;
import src.PatternsLoesung_V1.MVC_3_JTable.v1.model.*;
import src.PatternsLoesung_V1.MVC_3_JTable.v1.view.*;

public class App {

	public static void main(String[] args) {
		//erzeuge Modell
		Directory d = new Directory("D:/");
		
		//erzeuge eine View und uebergebe Modell
		JFrame f;
		f= new DirectoryViewer(d, "Viewer 1");
		f= new DirectoryViewer(d, "Viewer 2"); f.setLocation(700,  0);

	}
}
