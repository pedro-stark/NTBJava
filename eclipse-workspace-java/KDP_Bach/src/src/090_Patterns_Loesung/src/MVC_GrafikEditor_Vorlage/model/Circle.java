package MVC_GrafikEditor_Vorlage.model;

import java.awt.Color;

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
		//TODO
		return 0;
	}
	
	public int getBoundingBoxHeight() {
		//TODO
		return 0;
	}
	
	public String toString(int level) {
		return super.toString(level) + " r: " + radius; 
	}
}
