package src.SudokuLoesung;
public class MySudoku {

	public static void update() {
		// Berechnen Sie fuer jede Zeile, Spalte, Quadrat und Zelle, welche
		// Werte noch zulaessig sind!
		// Arbeiten Sie mit Bit-Operationen!
		// Fuehren Sie bei Bedarf weitere Methoden ein!

		int r, c, sr, sc;
		int v, w;

		// Zeilen
		for (r = 0; r < 9; r++) {
			v = 0x1FF;
			for (c = 0; c < 9; c++) {
				w = Sudoku.getField(r, c);
				if ((w & (w - 1)) == 0)
					v &= ~w;
			}
			Sudoku.setRow(r, v);
		}

		// Spalten
		for (c = 0; c < 9; c++) {
			v = 0x1FF;
			for (r = 0; r < 9; r++) {
				w = Sudoku.getField(r, c);
				if ((w & (w - 1)) == 0)
					v &= ~w;
			}
			Sudoku.setCol(c, v);
		}

		// Quadrate
		for (sr = 0; sr < 3; sr++) {
			for (sc = 0; sc < 3; sc++) {
				v = 0x1FF;
				for (r = 0; r < 3; r++) {
					for (c = 0; c < 3; c++) {
						w = Sudoku.getField(3 * sr + r, 3 * sc + c);
						if ((w & (w - 1)) == 0)
							v &= ~w;
					}
				}
				Sudoku.setSquare(sr, sc, v);
			}
		}

		// Zellen
		for (r = 0; r < 9; r++) {
			for (c = 0; c < 9; c++) {

				v = 0x1FF;
				w = Sudoku.getField(r, c);
				if ((w != 0 && (w & (w - 1)) == 0)) {
					v = w;
				} else {
					v = Sudoku.getRow(r) & Sudoku.getCol(c)
							& Sudoku.getSquare(r / 3, c / 3);
				}
				Sudoku.setField(r, c, v);
			}
		}
	}
}
