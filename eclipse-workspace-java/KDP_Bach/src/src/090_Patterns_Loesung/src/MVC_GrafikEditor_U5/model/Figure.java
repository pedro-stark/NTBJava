package MVC_GrafikEditor_U5.model;

import java.util.*;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import MVC_GrafikEditor_U5.view.DrawingViewer;

public class Figure implements TreeModel, TableModel {
	protected int x, y;
	protected Color color;
	protected Figure parent;
	
	private List<TableModelListener> observers_tables;
	private List<TreeModelListener> observers_trees;
	private List<DrawingViewer> observers_drawings;
	
	public Figure(int x, int y, Color c) {
		observers_tables = new ArrayList<>();
		observers_trees = new ArrayList<>();
		observers_drawings = new ArrayList<>();

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
		notifyObservers();
	}

	public int getY() {
		return y;
	}
	
	public int getAbsY() {
		return parent != null ? parent.getAbsY() + getY() : getY();
	}

	public void setY(int y) {
		this.y = y;
		notifyObservers();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
		notifyObservers();
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
	//Observer Pattern
	//
	public void attach(DrawingViewer dv) {
		observers_drawings.add(dv);
	}
	
	protected void notifyObservers() {
		for (DrawingViewer l : observers_drawings) {
			l.update();
		}

		for (TableModelListener l : observers_tables) {
			l.tableChanged(new TableModelEvent(this));
		}

		for (TreeModelListener l : observers_trees) {
			l.treeStructureChanged(new TreeModelEvent(this, new TreePath(getRoot())));
		}
		
		if (parent != null) {
			parent.notifyObservers();
		}
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
	public void addTreeModelListener(TreeModelListener l) {
		observers_trees.add(l);
	}
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		observers_trees.remove(l);
	}

	@Override
	public void valueForPathChanged(TreePath p, Object info) {
		//notify?
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
		observers_tables.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		observers_tables.remove(l);
	}

	@Override
	public void setValueAt(Object val, int row, int col) {
		if (col == 1) { setX((Integer)val); } 
		if (col == 2) { setY((Integer)val); } 
	}

}
