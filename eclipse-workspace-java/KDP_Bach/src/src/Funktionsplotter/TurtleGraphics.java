package src.Funktionsplotter;
/*
 * Carlo Bach, 16.10.2007
 * Version 1.1, C. Bach 23.10.2009
 *  
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TurtleGraphics extends JFrame {
	
	private static TurtleGraphics instance;
	
	public static TurtleGraphics getInstance() {
		if (instance == null) {
			instance = new TurtleGraphics();
		}
		return instance;
	}
	
	private JLabel statusPosition;
	private JLabel statusColor;
	private JCheckBox statusPenUp;
	
	
	private TurtleXYColorPlane plane;
	public TurtleXYColorPlane getXYColorPlane() {
		return plane;
	}
	
	private TurtleGraphics() {
		super("Turtle Graphics V1.2, C.Bach");
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		plane = new TurtleXYColorPlane();
		this.getContentPane().add(new JScrollPane(plane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		//Toolbar
		JToolBar tb = new JToolBar();
		tb.setFloatable(false);
		this.getContentPane().add(tb, BorderLayout.NORTH);		
		
		statusPosition = new JLabel(" ");
		statusColor = new JLabel(" Color ");
		statusPenUp = new JCheckBox("Pen up"); statusPenUp.setEnabled(false);
		tb.add(statusPosition);
		tb.add(statusPenUp);
		tb.add(statusColor);
		
		
		tb.addSeparator();

		JButton b = new JButton("Home");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Turtle.home();
			}
		});
		tb.add(b);
				
		this.pack();
		this.setVisible(true);
	}
	
	public void update() {
		statusPosition.setText(" x: " + (int)Turtle.getX() + " y: " + (int)Turtle.getY() + " a: " + (int)Turtle.getAngle() + " ");
		statusPenUp.setSelected(Turtle.isPenUp());
		statusColor.setForeground(new Color(Turtle.getColor()));
	}
}
