package MVC_1_Dec2Bin.v2_mitJavaObserverPattern;

import javax.swing.*;
import java.util.*;

public class View2 extends JFrame implements Observer {
	private JTextField output;
	
	public View2(Model m ) {
		super("Alternative View");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		m.addObserver(this);
		
		output = new JTextField(Integer.toBinaryString(m.getNumber()));
		add(output);
		
		pack();
		setVisible(true);
	}

	@Override
	public void update(Observable model, Object info) {
		Model m = (Model)model;
		output.setText(Integer.toBinaryString(m.getNumber()));
	}
}
