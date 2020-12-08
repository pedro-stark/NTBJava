package src.Sudoku;
public class MySudoku extends Sudoku {

	public void doUpdate() {
		// Berechnen Sie fuer jede Zeile, Spalte, Quadrat und Zelle, welche
		// Werte noch zulaessig sind!
		// Arbeiten Sie mit Bit-Operationen!
		// Fuehren Sie bei Bedarf weitere Methoden ein!

		int r, c, sr, sc;
		int v, w;

		// Zeilen
		for (r = 0; r < 9; r++) {
			v = 0x1FF; //alle Möglichkeiten
			for (c = 0; c < 9; c++) {
				w = getField(r, c);
				//your code goes here: welche Möglichkeiten bleiben offen?
			}
			setRow(r, v);
		}

		// Spalten

		// Quadrate

		// Zellen
	}
	
	
	
	public static void main(String[] args) {
		new Application(args, new MySudoku());
	}

}
