package MVC_GrafikEditor_U2.view;

import java.awt.*;
import javax.swing.*;
import MVC_GrafikEditor_U2.model.*;

public class Drawing extends JComponent {
	private Figure root;
	
	public Drawing(Figure r) {
		root = r;
	}

	@Override
	protected void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		
		//clear 
		gc.setColor(Color.WHITE);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//draw a grid
		gc.setColor(Color.GRAY); int spacing = 50;
		for (int x = 0; x < getWidth(); x +=spacing) {
			gc.drawLine(x, 0, x, getHeight());
		}
		for (int y = 0; y < getHeight(); y +=spacing) {
			gc.drawLine(0, y, getWidth(), y);
		}

		//draw figures with a thicker stroke (Stiftstärke)
		Stroke original =((Graphics2D)gc).getStroke(); 
		((Graphics2D)gc).setStroke(new BasicStroke(2));
		
		root.paint(gc);
		
		((Graphics2D)gc).setStroke(original);
	}

	
	

}
