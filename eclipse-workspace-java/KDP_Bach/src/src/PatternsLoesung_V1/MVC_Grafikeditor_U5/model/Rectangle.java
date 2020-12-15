package src.PatternsLoesung_V1.MVC_Grafikeditor_U5.model;

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
		notifyObservers();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		notifyObservers();
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

	//
	//Table
	//
	@Override
	public Class<?> getColumnClass(int index) {
		//0: Classname; 1: x; 2: y; 3: Color; 4: w, 5: h
		if (index == 4) return Integer.class;
		if (index == 5) return Integer.class;
		return super.getColumnClass(index);
	}

	@Override
	public int getColumnCount() {
		return super.getColumnCount() + 2;
	}

	@Override
	public String getColumnName(int index) {
		if (index == 4) return "W";
		if (index == 5) return "H";
		return super.getColumnName(index);
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (col == 4) return this.getBoundingBoxWidth();
		if (col == 5) return this.getBoundingBoxHeight();
		return super.getValueAt(row, col);
	}

}
