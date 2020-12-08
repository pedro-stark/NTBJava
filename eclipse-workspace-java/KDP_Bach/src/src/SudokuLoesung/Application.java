package src.SudokuLoesung;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/*
 * Created on 28.9.2017
 *
 */

/**
 * @author bbach
 *
 */
public class Application extends JFrame {
	private JButton bUpdate;

	public Application(String[] args) {
		super("Sudoku - C. Bach, 28.9.2017");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Sudoku.game = new SudokuGamefield();
		this.getContentPane().add(Sudoku.game);

		JToolBar tb = new JToolBar();
		tb.setFloatable(false);
		AbstractButton mi;

		mi = new JButton("Load ...");
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(Application.this) == JFileChooser.APPROVE_OPTION) {
					File f =chooser.getSelectedFile();
					Sudoku.loadGame(f.getPath());
				}
			}
		});
		tb.add(mi);

		mi = new JCheckBox("Automatic Update", Sudoku.automaticUpdate);
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Sudoku.automaticUpdate = ((JCheckBox)ae.getSource()).isSelected();
				bUpdate.setEnabled(!Sudoku.automaticUpdate);
				Sudoku.update();
			}
		});
		tb.add(mi);

		bUpdate = new JButton("Update");
		bUpdate.setEnabled(!Sudoku.automaticUpdate);
		bUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Sudoku.update();
			}
		});
		tb.add(bUpdate);

		this.getContentPane().add(tb, BorderLayout.NORTH);

		this.pack();

		this.setVisible(true);

		if (args.length > 0) {
			Sudoku.loadGame(args[0]);
		}

		Sudoku.update();
	}

}
