package src.SudokuLoesung;

public class Sudoku {
	
	public static SudokuGamefield game;
	
	public static boolean automaticUpdate; 
	
	private static boolean changed2One;
	
	private static int[] rows;
	private static int[] cols;
	private static int[][] squares;
	private static int[][] fields;
	private static boolean[][] enteredByUser;
	
	
	static {
		int i, j;
		
		game = null;
		automaticUpdate = false;
		
		rows = new int[9];
		cols = new int[9];
		for (i = 0; i < 9; i++) {
			rows[i] = 0x1FF;
			cols[i] = 0x1FF;
		}
		
		squares = new int[3][];
		for (i = 0; i < 3; i++) {
			squares[i] = new int[3];
			for (j = 0; j < 3; j++) {
				squares[i][j] = 0x1FF;
			}
		}

		fields = new int[9][];
		enteredByUser = new boolean[9][];
		for (i = 0; i < 9; i++) {
			fields[i] = new int[9];
			enteredByUser[i] = new boolean[9];
			for (j = 0; j < 9; j++) {
				fields[i][j] = 0x1FF;
				enteredByUser[i][j] = false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Application(args);
	}
	
	public static boolean loadGame(String filename) {
		In.open(filename);
		if (!In.done()) return false;
		
		for (int i = 0; i < 9*9; i++) {
			int v = In.readInt();
			if (!In.done()) return false;
			fields[i/9][i%9] = v > 0 ? 1 << (v - 1) : 0x1FF;
			enteredByUser[i/9][i%9] = v != 0;
		}
		
		update();
		return true;
	}
	
	public static void storeGame() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("" + getField(i, j) + "\t");
			}
			System.out.println();
		}
	}
	
	
	public static int getField(int row, int col){
		return fields[row][col];
	}
	public static void setField(int row, int col, int val){
		if (fields[row][col] == val) return;
		
		fields[row][col] = val;
		if (val > 0 && (val & (val-1)) == 0) changed2One = true;
	}
	
	public static int getRow(int row){
		return rows[row];
	}
	public static void setRow(int row, int val){
		rows[row] = val;
	}

	public static int getCol(int col){
		return cols[col];
	}
	public static void setCol(int col, int val){
		cols[col] = val;
	}

	public static int getSquare(int row, int col){
		return squares[row][col];
	}
	public static void setSquare(int row, int col, int val){
		squares[row][col] = val;
	}
	

	public static boolean getEnteredByUser(int row, int col){
		return enteredByUser[row][col];
	}
	public static void setEnteredByUser(int row, int col, boolean val){
		enteredByUser[row][col] = val;
	}
	
	
	public static void update() {
		if (game == null) return;

		int i = 1;
		do {
			changed2One = false;
			MySudoku.update();
			i++;
		} while (automaticUpdate && changed2One);
		
		game.update();
	}

}
