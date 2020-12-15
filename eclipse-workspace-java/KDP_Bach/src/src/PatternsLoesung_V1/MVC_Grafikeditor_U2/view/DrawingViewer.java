package src.PatternsLoesung_V1.MVC_Grafikeditor_U2.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import src.PatternsLoesung_V1.MVC_Grafikeditor_U2.model.*;

//Fixfertig - Keine Anpassungen nötig
public class DrawingViewer extends JFrame { 
	private Group root;
	private Drawing drawing;
	private JTextField parameters;
	
	public DrawingViewer(Group root) {
		super("Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.root = root;
		
		add(createToolbar(), BorderLayout.NORTH);

		drawing = new Drawing(root);
		add(drawing, BorderLayout.CENTER);
		
        setSize(750,500);
        setVisible(true);
	}

	protected JComponent createToolbar() {
		JToolBar tb = new JToolBar();
		
		JButton b = new JButton("Refresh");
		b.addActionListener(e -> { drawing.repaint(); });
		tb.add(b);

		b = new JButton("Add Circle (x,y,r,color)");
		b.addActionListener(e -> {			
			try {
				String[] p = parameters.getText().split(",");
				int x = Integer.parseInt(p[0].trim()); int y = Integer.parseInt(p[1].trim()); int r = Integer.parseInt(p[2].trim());
				int c = Integer.parseInt(p[3].trim(),16);
				root.add(new Circle(x, y, new Color(c), r));
				drawing.repaint();
			} catch (Exception ex) {
				parameters.setText("ERROR! x,y,r,color");
			}
		});
		tb.add(b);
		
		b = new JButton("Add Rectangle (x,y,w,h,color)");
		b.addActionListener(e -> {			
			try {
				String[] p = parameters.getText().split(",");
				root.add(new Rectangle(Integer.parseInt(p[0].trim()), Integer.parseInt(p[1].trim()), new Color(Integer.parseInt(p[4].trim(),16)), Integer.parseInt(p[2].trim()), Integer.parseInt(p[3].trim())));
				drawing.repaint();
			} catch (Exception ex) {
				parameters.setText("ERROR! x,y,w,h,color");
			}
		});
		tb.add(b);
		
		parameters = new JTextField("50, 40, 30, FFFF00"); parameters.setHorizontalAlignment(JTextField.RIGHT);
		tb.add(parameters);
	
		return tb;
	}

}
