package src.PatternsLoesung_V1.MVC_Grafikeditor_U4.model;

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
		int xx = getAbsX();
		gc.setColor(getColor());
		gc.drawOval(getAbsX(), getAbsY(), getBoundingBoxWidth(), getBoundingBoxHeight());
	}	
	
	//
	//Table
	//
	@Override
	public Class<?> getColumnClass(int index) {
		//0: Classname; 1: x; 2: y; 3: Color; 4: radius
		if (index == 4) return Integer.class;
		return super.getColumnClass(index);
	}

	@Override
	public int getColumnCount() {
		return super.getColumnCount() + 1;
	}

	@Override
	public String getColumnName(int index) {
		//0: Classname; 1: x; 2: y; 3: Color; 4: radius
		if (index == 4) return "Radius";
		return super.getColumnName(index);
	}

	@Override
	public Object getValueAt(int row, int col) {
		//0: Classname; 1: x; 2: y; 3: Color; 4: radius
		if (col == 4) return getRadius();
		return super.getValueAt(row, col);
	}
	
}
