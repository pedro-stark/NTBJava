package src.PatternsLoesung.MVC_3_JTable.v1.view;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import src.PatternsLoesung.MVC_3_JTable.v1.model.*; 

public class MyWindow_JTable extends JFrame implements TableModelListener {
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	
	private Personenliste model;
	private JTable t;

	public MyWindow_JTable(Personenliste model, String version) {
		super("Personenliste als Tabelle " + version);

		this.model = model;

		//diese Sicht soll bei Aenderungen im Modell benachrichtigt werden
		model.addTableModelListener(this); 


		//Content 
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(createContent(), BorderLayout.CENTER);

		//berechne neues Layout
		//setSize(WIDTH, HEIGHT);
		pack();

		//Terminierung der Applikation
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Display
		setVisible(true);
	}


	protected JPanel createContent() {
		JPanel p = new JPanel(); 
		t = new JTable(model);
		p.add(new JScrollPane(t));
		return p;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("updateView called: " + this.getTitle() + " TableModelEvent: " + e);
		t.updateUI();	
	}




}

