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
	
	private Sudoku game;

	public Application(String[] args, Sudoku game) {
		super("Sudoku - C. Bach, 28.9.2017");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		game.gamefield = new SudokuGamefield();
		this.getContentPane().add(game.gamefield);

		JToolBar tb = new JToolBar();
		tb.setFloatable(false);
		AbstractButton mi;

		mi = new JButton("Load ...");
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(Application.this) == JFileChooser.APPROVE_OPTION) {
					File f =chooser.getSelectedFile();
					game.loadGame(f.getPath());
				}
			}
		});
		tb.add(mi);

		mi = new JCheckBox("Automatic Update", game.automaticUpdate);
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				game.automaticUpdate = ((JCheckBox)ae.getSource()).isSelected();
				bUpdate.setEnabled(!game.automaticUpdate);
				game.update();
			}
		});
		tb.add(mi);

		bUpdate = new JButton("Update");
		bUpdate.setEnabled(!game.automaticUpdate);
		bUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				game.update();
			}
		});
		tb.add(bUpdate);

		this.getContentPane().add(tb, BorderLayout.NORTH);

		this.pack();

		this.setVisible(true);

		if (args.length > 0) {
			game.loadGame(args[0]);
		}

		game.update();
	}
	
	
	

}
