package src.Patterns.MVC_1_Dec2Bin.v2_JavaObserverPattern;

import javax.swing.*;
import java.util.*;

public class View2 extends JFrame implements Observer {
	private JTextField output;
	
	public View2(Model m ) {
		super("Alternative View");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
	}

	@Override
	public void update(Observable model, Object info) {
		Model m = (Model)model;
		//TODO
	}
}
