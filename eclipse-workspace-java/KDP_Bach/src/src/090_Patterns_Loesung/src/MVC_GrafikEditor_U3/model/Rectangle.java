package MVC_GrafikEditor_U3.model;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure {
	protected int width, height;
	
	public Rectangle(int x, int y, Color c, int w, int h) {
		super(x, y, c);
		setWidth(w);
		setHeight(h);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBoundingBoxWidth() {
		return width;
	}
	
	public int getBoundingBoxHeight() {
		return height;
	}
	
	public String toString(int level) {
		return super.toString(level) + " w: " + width + ", h: " + height; 
	}
	
	public void paint(Graphics gc) {
		gc.setColor(getColor());
		gc.drawRect(getAbsX(), getAbsY(), getWidth(), getHeight());
	}	
}
