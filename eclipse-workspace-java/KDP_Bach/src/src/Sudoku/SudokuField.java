package src.Sudoku;

import java.awt.*;
import java.awt.event.*;
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
public class SudokuField extends JPanel implements ActionListener {
	
	public static final int TYPE_FIELD = 0;
	public static final int TYPE_ROW = 1;
	public static final int TYPE_COL = 2;
	public static final int TYPE_SQUARE = 3;
	public static final int TYPE_EMPTY = 4;
	
	private int type;
	private int row;
	private int col;
	

	public SudokuField(int type, int row, int col) {
		this.row = row;
		this.col = col;
		this.type = type;
		
		this.setLayout(new GridLayout(3, 3));
		this.setBorder(LineBorder.createGrayLineBorder());
		
		JButton b;
		for (int i = 1; i < 10; i++) {
			b = type == TYPE_EMPTY ? new JButton("   ") : new JButton(" " + i + " ");
			b.setBorder(new EmptyBorder(0,3,0,3));
			b.addActionListener(this);
			this.add(b);
		}
		
		update();
	}
	
	private int getValue() {
		switch(type) {
		case SudokuField.TYPE_FIELD: return Sudoku.game.getField(row, col); 
		case SudokuField.TYPE_ROW: return Sudoku.game.getRow(row); 
		case SudokuField.TYPE_COL: return Sudoku.game.getCol(col); 
		case SudokuField.TYPE_SQUARE: return Sudoku.game.getSquare(row, col); 
		}
		return 0;
	}
	
	public void update() {
		int v = getValue();
		int w = v;
		for (int i = 0; i < 9; i++) {
			AbstractButton b = (AbstractButton)this.getComponent(i);
			b.setEnabled((v & 0x1) > 0);
			//b.setBackground(b.isEnabled() ? (type == TYPE_FIELD ? (w & (w-1)) == 0 ? Color.orange: Color.GREEN : Color.WHITE) : Color.LIGHT_GRAY);
			b.setBackground(b.isEnabled() ? (type == TYPE_FIELD ? Sudoku.game.getEnteredByUser(row, col) ? Color.orange: Color.GREEN : Color.WHITE) : Color.LIGHT_GRAY);
			v = v >> 1;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (type != TYPE_FIELD) return;
		
		JButton b = (JButton)e.getSource();
		int v = Integer.parseInt(b.getText().trim());
		
		Sudoku.game.setEnteredByUser(row, col, true);
		Sudoku.game.setField(row, col, 1 << (v-1));
		Sudoku.game.update();
	}
}
