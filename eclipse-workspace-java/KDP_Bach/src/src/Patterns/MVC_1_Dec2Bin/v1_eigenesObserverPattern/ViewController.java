package src.Patterns.MVC_1_Dec2Bin.v1_eigenesObserverPattern;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//TODO Registrierung (im Konstruktor)
//TODO Controller: Modelländerung (actionPerformed)
//TODO View: Modelländerung sichtbar machen (update)

public class ViewController extends JFrame implements ActionListener {
	private Model model;
	
	private JTextField decimalField;
	private JTextField resultField;
	
	public ViewController(Model m) {
		super("Two's complement of a decimal number");
		
		//TODO bei Modell registrieren
	
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Number to convert: "));
		decimalField = new JTextField("", 32); //TODO: Darstellung des aktuellen Modell-Werts
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
			//TODO: Modell ändern 
		}
		catch (NumberFormatException ex) {
			resultField.setText("Error: wrong number format!");
		}
	}

	public void update() {
		//TODO: Aktualisieren aus Modell
	}
	

}
