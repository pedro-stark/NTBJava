package src.PatternsLoesung_V1.MVC_Grafikeditor_U4.model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelListener;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Figure implements TreeModel, TableModel {
	protected int x, y;
	protected Color color;
	protected Figure parent;
	
	public Figure(int x, int y, Color c) {
		setX(x);
		setY(y);
		setColor(c);
		parent = null;
	}

	public int getX() {
		return x;
	}
	
	public int getAbsX() {
		return parent != null ? parent.getAbsX() + getX() : getX();
	}
		
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int getAbsY() {
		return parent != null ? parent.getAbsY() + getY() : getY();
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getBoundingBoxWidth() {
		return 0;
	}
	
	public int getBoundingBoxHeight() {
		return 0;
	}
	
	public String toString() {
		return toString(0);
	}
	
	public String toString(int level) {
		String s = ""; for (int i = 0; i < level; i++) { s += "  "; }
		return s + this.getClass().getName() 
				+ " (" + x + ", " + y + ", " 
				+ this.getBoundingBoxWidth() + ", " + this.getBoundingBoxHeight() + ") "
				+ this.color.toString()
				+ " <" + getAbsX() + ", " + getAbsY() + "> " 
				;
	}

	public void paint(Graphics gc) {
		//nothing to do
	}

	//
	//Tree
	//
	@Override
	public Object getChild(Object parent, int index) {
		return null; //See Group
	}

	@Override
	public int getChildCount(Object parent) {
		return 0;  //See Group
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		return 0; //See Group
	}

	@Override
	public Object getRoot() {
		return parent != null ? parent.getRoot() : this;
	}

	@Override
	public boolean isLeaf(Object o) {
		return true;
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
	}

	//
	//Table
	//
	@Override
	public Class<?> getColumnClass(int index) {
		//0: Classname; 1: x; 2: y; 3: Color
		if (index == 0) return String.class;
		if (index == 1) return Integer.class;
		if (index == 2) return Integer.class;
		if (index == 3) return Color.class;
		return null;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int index) {
		//0: Classname; 1: x; 2: y; 3: Color
		if (index == 0) return "Klasse";
		if (index == 1) return "X";
		if (index == 2) return "Y";
		if (index == 3) return "Farbe";
		return null;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int row, int col) {
		//0: Classname; 1: x; 2: y; 3: Color
		if (col == 0) return this.getClass().getSimpleName();
		if (col == 1) return getX();
		if (col == 2) return getY();
		if (col == 3) return getColor();
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		//nur x und y editierbar
		if (col == 1) return true;
		if (col == 2) return true;
		return false;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object val, int row, int col) {
		if (col == 1) { x = (Integer)val; } 
		if (col == 2) { y = (Integer)val; } 
	}

}
