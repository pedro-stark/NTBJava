package src.FunktionsplotterLoseung;

//
//Loesung zu Funktionsplotter
//C. Bach, 22.10.17
//

public class Plotter {

	//
	//Definition der Funktion
	//
	public static double f(double x) {
		return Math.sin(x);
	}

	
	//Definition des Zeichnungsprogramms
	public static void plot(double xmin, double xmax, double ymin, double ymax) {
		double x, y, w, z;
		double deltax = (xmax - xmin) / Turtle.WIDTH;
		Turtle.home();
		Turtle.setColor(0x0000FF); //blau
		Turtle.penDown();

		x = xmin;
		// Hinweis: xmax muss erreicht werden. Da Gleitkommazahlen aber nie 
		// auf Gleichheit getestet werden duerfen, wurde ein Epsilon-Term (siehe 
		// Gleitkommazahlen Merkblatt von C. Bach), hier 0.2 * deltax, hinzugefuegt.  
		while (x <= xmax + 0.2 * deltax) { 
			y = f(x);
			System.out.printf("y = f(y): %2$.2f = f(%1$.2f)\n", x, y);
			w = (x - xmin) * (Turtle.WIDTH-1) / (xmax - xmin);
			z = (y - ymin) * (Turtle.HEIGHT-1) / (ymax - ymin);
			Turtle.moveTo(w, z);
			x = x + deltax;
		}
	}

	public static void main(String[] args) {
		double xmin = -5.0, xmax = 5.0, ymin = -1.0, ymax = 1.0;

		try {
			//Interaktive Eingabe der Grenzen
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

