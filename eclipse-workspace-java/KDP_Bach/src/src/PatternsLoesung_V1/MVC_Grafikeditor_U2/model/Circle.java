package src.PatternsLoesung_V1.MVC_Grafikeditor_U2.model;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Figure {
	protected int radius;
	
	public Circle(int x, int y, Color c, int r) {
		super(x, y, c);
		setRadius(r);
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getBoundingBoxWidth() {
		return 2*radius;
	}
	
	public int getBoundingBoxHeight() {
		return 2*radius;
	}
	
	public String toString(int level) {
		return super.toString(level) + " r: " + radius; 
	}
	
	public void paint(Graphics gc) {
		gc.setColor(getColor());
		gc.drawOval(getAbsX(), getAbsY(), getBoundingBoxWidth(), getBoundingBoxHeight());
	}	
	
}
