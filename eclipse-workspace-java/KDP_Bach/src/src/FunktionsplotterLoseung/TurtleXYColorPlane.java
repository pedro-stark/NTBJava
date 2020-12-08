package src.FunktionsplotterLoseung;
/*
 * Carlo Bach, 16.10.2007
 * Version 1.1, 23.10.2009
 *  
 */

import java.awt.*;
import javax.swing.*;

public class TurtleXYColorPlane extends JPanel {
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 500;
	
	private Image offscreenImage; 
	
	public TurtleXYColorPlane() {
		offscreenImage = null;
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void clear() {
		Image img = getOffscreenImage();
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		repaint();
	}
	
	public void drawDot(int x0, int y0, int color) {
		drawLine(x0, y0, x0, y0, color);
	}

	public void drawLine(int x0, int y0, int x1, int y1, int color) {
		Image img = getOffscreenImage();
		Graphics g = img.getGraphics();
		
		//coordinate transformation
		y0 = this.getHeight() - 1 - y0;
		y1 = this.getHeight() - 1 - y1;
		
		//change color
		if (g.getColor().getRGB() != color) {
			g.setColor(new Color(color));
		}
		
		//draw
		g.drawLine(x0, y0, x1, y1);
		
		//update display (could be optimized)
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (offscreenImage != null) {
			g.drawImage(offscreenImage, 0, 0, null);
		}
	}
	
	
	protected Image getOffscreenImage() {
		if (offscreenImage == null) {
			offscreenImage = this.createImage(this.getWidth(), this.getHeight());
		}
		return offscreenImage;
	}
}
