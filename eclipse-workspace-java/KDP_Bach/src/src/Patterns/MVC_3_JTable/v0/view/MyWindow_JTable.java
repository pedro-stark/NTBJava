package src.Patterns.MVC_3_JTable.v0.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

import src.Patterns.MVC_3_JTable.v0.model.Personenliste; 

public class MyWindow_JTable extends JFrame {
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	
	private Personenliste model;
	private JTable t;

	public MyWindow_JTable(Personenliste model, String version) {
		super("Personenliste als Tabelle " + version);

		this.model = model;

		//diese Sicht soll bei Aenderungen im Modell benachrichtigt werden
		model.attach(this); 


		//Content 
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(createContent(), BorderLayout.CENTER);

		//berechne neues Layout
		//setSize(WIDTH, HEIGHT);
		pack();

		//Terminierung der Applikation
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(
				new WindowAdapter() {		
					public void windowClosed(WindowEvent e) {
						System.exit(0); 
					}

					public void windowClosing(WindowEvent e) {
						dispose();
					}
				}
				);

		//Display
		setVisible(true);
	}


	protected JPanel createContent() {
		JPanel p = new JPanel(); 
		t = new JTable(model);
		p.add(new JScrollPane(t));
		return p;
	}

	public void updateView() {
		System.out.println("updateView called");
		t.updateUI();
	}




}

