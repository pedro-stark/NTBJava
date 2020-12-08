package src.Patterns.MVC_2_Texteditor;

/*
	C. Bach, 21.1.2004

	JTextArea und Documents	
	
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*; 

class MyWindow_PlainDocument extends JFrame {
	static final int WIDTH = 400;
	static final int HEIGHT = 500;
	
	MyWindow_PlainDocument(String title) {
		super(title);
		
		//Content 
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(createContent(), BorderLayout.CENTER);

		//berechne neues Layout
		setSize(WIDTH, HEIGHT);
		
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
		p.setLayout(new GridLayout(3,1));

		//Model		
		Document d = new PlainDocument();
		
		//Viewer 1
		JTextArea ta1 = new JTextArea(d);
		ta1.setBorder(BorderFactory.createTitledBorder("Texteditor 1"));
		
		//Viewer 2
		JTextArea ta2 = new JTextArea(d);
		ta2.setBorder(BorderFactory.createTitledBorder("Texteditor 2"));
		
		//Viewer 3
		JTextArea ta3 = new JTextArea(d);
		ta3.setBorder(BorderFactory.createTitledBorder("Texteditor 3"));

		p.add(ta1);
		p.add(ta2);
		p.add(ta3);
		
		return p;
	}



	public static void main(String[] args) {
		//do all the application initialization stuff		
		JFrame frame = new MyWindow_PlainDocument("MVC with Documents");		
	}	
}

