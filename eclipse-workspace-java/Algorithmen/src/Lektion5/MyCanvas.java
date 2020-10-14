package Lektion5;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;


class MyCanvas extends Canvas {
	ArrayList<Line> lines = new ArrayList<Line>();
	public void addLineToPaint(Line line) {
		lines.add(line);
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		int centerX = this.getWidth()/2;
		int centerY = this.getHeight()/2;
		for (Line line : (ArrayList<Line>)(lines.clone())) {
			line.draw(g,centerX,centerY);
		}
	}
}