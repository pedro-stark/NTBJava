package MVC_1_Dec2Bin.v2_mitJavaObserverPattern;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ViewController extends JFrame 
	implements ActionListener, Observer {
	private Model model; //***neu

	private JTextField decimalField;
	private JTextField resultField;
	
	public ViewController(Model m) {
		super("Two's complement of a decimal number");

		model = m; //neu
		model.addObserver(this); //neu
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Number to convert: "));
		decimalField = new JTextField(""+model.getNumber(), 32); //neu
		panel.add(decimalField);
		add(panel,BorderLayout.NORTH);
		
		JButton umwandelnKnopf = new JButton("Convert!");
		umwandelnKnopf.addActionListener(this);
		add(umwandelnKnopf,BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.add(new JLabel("Two's complement:"));
		resultField = new JTextField(32);
		panel.add(resultField);
		add(panel,BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			int num = Integer.parseInt(decimalField.getText()); 
			this.model.setNumber(num); //neu
		}
		catch (NumberFormatException ex) {
			resultField.setText("Error: wrong number format!");
		}
	}

	public void update(Observable m, Object info) { //neu
		decimalField.setText("" + model.getNumber()); //neu
		resultField.setText(Integer.toBinaryString(model.getNumber())); //neu
	}
}
