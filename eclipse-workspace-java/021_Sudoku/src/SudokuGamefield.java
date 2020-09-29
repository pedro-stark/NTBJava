import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/*
 * Created on 12.12.2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author bbach
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SudokuGamefield extends JPanel {

	public SudokuGamefield() {
		this.setLayout(new GridLayout(13, 13));
		
		int i; int j; int k;
		
		//1st. line: col fields
		this.add(create(SudokuField.TYPE_EMPTY, 0, 0, 0, 0, 0, 0));
		for (i = 0; i < 3; i++) {
			this.add(create(SudokuField.TYPE_EMPTY, 0, 0,       0, 0, 1, 0));
			this.add(create(SudokuField.TYPE_COL, 0, 3 * i,     0, 1, 1, 0));
			this.add(create(SudokuField.TYPE_COL, 0, 3 * i + 1, 0, 1, 1, 0));
			this.add(create(SudokuField.TYPE_COL, 0, 3 * i + 2, 0, 1, 1, 1));
		}
		
		//rest
		for (i = 0; i < 3; i++) {
			//1. row
			this.add(create(SudokuField.TYPE_EMPTY, 0, 0, 0, 0, 1, 1));
			for (j = 0; j < 3; j++) {
				this.add(create(SudokuField.TYPE_SQUARE, i, j, 1, 1, 1, 1));
				this.add(create(SudokuField.TYPE_EMPTY,  0, 0, 1, 0, 1, 0));
				this.add(create(SudokuField.TYPE_EMPTY,  0, 0, 1, 0, 1, 0));
				this.add(create(SudokuField.TYPE_EMPTY,  0, 0, 1, 0, 1, 1));
			}
			
			//next 3 rows
			for (k = 0; k < 3; k++) {
				this.add(create(SudokuField.TYPE_ROW, 3 * i + k, 0,               0, 0, 1, 1));
				for (j = 0; j < 3; j++) {
					this.add(create(SudokuField.TYPE_EMPTY, 0, 0,                 0, 1, 0, 0));
					this.add(create(SudokuField.TYPE_FIELD, 3 * i + k, 3 * j,     0, 1, 1, 0));
					this.add(create(SudokuField.TYPE_FIELD, 3 * i + k, 3 * j + 1, 0, 1, 1, 0));
					this.add(create(SudokuField.TYPE_FIELD, 3 * i + k, 3 * j + 2, 0, 1, 1, 1));
				}
				
			}
		}
		
		Sudoku.game.update();
	}

	private JComponent create(int type, int row, int col, int borderTop, int borderLeft, int borderBottom, int borderRight) {
		JComponent c = new SudokuField(type, row, col);
		c.setBorder(new MatteBorder(borderTop, borderLeft, borderBottom, borderRight, Color.BLACK));
		return c;
	}
	
	
	public void update() {
		for (int i = 0; i < this.getComponentCount(); i++) {
			SudokuField f = (SudokuField)this.getComponent(i);
			f.update();
		}
	}

}
