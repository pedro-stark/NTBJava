package src.Funktionsplotter;


//
//Vorlage zu Funktionsplotter
//C. Bach, 6.10.18
//

public class Plotter {

	//
	//Definition der Funktion
	//
	public static double f(double x) {
		//TODO
		return 0.0;
	}

	
	//Definition des Zeichnungsprogramms
	public static void plot(double xmin, double xmax, double ymin, double ymax) {
		double x, y, w, z;
		double deltax = (xmax - xmin) / Turtle.WIDTH;
		Turtle.home();
		Turtle.setColor(0x0000FF); //blau
		Turtle.penDown();
		
		//TODO

	}

	public static void main(String[] args) {
		double xmin = -5.0, xmax = 5.0, ymin = -1.0, ymax = 1.0;

		try {
			//Eingabe der Grenzen über die Kommandozeile
			xmin = Double.parseDouble(args[0]);
			xmax = Double.parseDouble(args[1]);
			ymin = Double.parseDouble(args[2]);
			ymax = Double.parseDouble(args[3]);			
		} catch (Exception ex) {
			System.err.println("plotter.Plotter <xmin (double)> <xmax (double)> <ymin (double)> <ymaxn (double)>");
		}

		//Aufruf des Zeichnungsprogramms mit den eingegeben Grenzen
		plot(xmin, xmax, ymin, ymax); 
	}

}

