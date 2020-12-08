package MVC_1_Dec2Bin.v1_mitEigenerObserverPatternImplementation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewController extends JFrame implements ActionListener {
	private Model model; //***neu

	private JTextField decimalField;
	private JTextField resultField;
	
	public ViewController(Model m) {
		super("Two's complement of a decimal number");

		model = m; //neu
		model.attach(this); //neu
		
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

	public void update() { //neu
		decimalField.setText(""+model.getNumber()); //neu
		resultField.setText(Integer.toBinaryString(model.getNumber())); //neu
	}
}
