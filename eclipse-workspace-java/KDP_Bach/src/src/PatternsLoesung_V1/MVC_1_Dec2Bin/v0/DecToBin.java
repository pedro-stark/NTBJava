package src.PatternsLoesung_V1.MVC_1_Dec2Bin.v0;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DecToBin extends JFrame implements ActionListener {
	private JTextField decimalField;
	private JTextField resultField;
	
	public DecToBin() {
		super("Two's complement of a decimal number");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Number to convert: "));
		decimalField = new JTextField("7",32);
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
		
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			int num = Integer.parseInt(decimalField.getText()); 
			resultField.setText(Integer.toBinaryString(num));
		}
		catch (NumberFormatException ex) {
			resultField.setText("Error: wrong number format!");
		}
	}
	
	public static void main(String[] args) {
		new DecToBin();
	}

}
