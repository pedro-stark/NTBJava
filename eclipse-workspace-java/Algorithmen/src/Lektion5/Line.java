package Lektion5;

import java.awt.Graphics;

class Line {
	int x1,x2,y1,y2;
	Line(double x1, double y1, double x2, double y2) {
		this.x1 = (int) x1;
		this.y1 = (int) y1;
		this.x2 = (int) x2;
		this.y2 = (int) y2;
	}
	Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	void draw(Graphics g, int centerX, int centerY) {
		g.drawLine(centerX+x1,centerY-y1,centerX+x2,centerY-y2);
	}
}