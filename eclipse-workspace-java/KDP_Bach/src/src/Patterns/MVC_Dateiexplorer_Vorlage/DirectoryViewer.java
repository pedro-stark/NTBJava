package src.Patterns.MVC_Dateiexplorer_Vorlage;
/*
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.text.*;
import MVC_3_JTable.v1.model.*; 

public class DirectoryViewer extends JFrame 
	implements TableModelListener {
	
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	
	private Directory model;
	private JTable t;

	public DirectoryViewer(Directory model, String version) {
		super("Directory-Viewer " + version);

		this.model = model;

		//diese Sicht soll bei Aenderungen im Modell benachrichtigt werden
		model.addTableModelListener(this); 


		//Content 
		add(createContent(), BorderLayout.CENTER);
		add(createToolbar(), BorderLayout.NORTH);

		//berechne neues Layout
		//setSize(WIDTH, HEIGHT);
		pack();

		//Terminierung der Applikation
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Display
		setVisible(true);
	}


	protected JComponent createContent() {
		t = new JTable(model);
		t.setFillsViewportHeight(true); 
		return new JScrollPane(t);
	}
	
	protected JComponent createToolbar() {
		JToolBar tb = new JToolBar();
		
		JButton b = new JButton("Refresh");
		b.addActionListener(e -> {			
			model.setDirectory(model.getCurrentDirectory());
		});
		tb.add(b);

		b = new JButton("Change Directory");
		b.addActionListener(e -> {			
			String n = t.getValueAt(t.getSelectedRow(), 4).toString();
			model.setDirectory(n);
		});
		tb.add(b);
	
		b = new JButton("Go Up");
		b.addActionListener(e -> {			
			model.setDirectory(model.getParentOfCurrentDirectory());
		});
		tb.add(b);

		return tb;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("updateView called: " + this.getTitle() + " TableModelEvent: " + e);
		t.updateUI();	
	}




}

*/
