package MVC_GrafikEditor_U5.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelListener;

public class Group extends Figure {
	protected ArrayList<Figure> members;
	protected boolean boundingBoxIsDrawn;

	public Group(int x, int y) {
		super(x, y, Color.WHITE);
		members = new ArrayList<>();
		
		boundingBoxIsDrawn = true;
	}
	
	public void add(Figure f) {
		members.add(f);
		f.parent = this;
		notifyObservers(); 
	}
	
	public boolean isBoundingBoxDrawn() {
		return boundingBoxIsDrawn;
	}

	public void setBoundingBoxDrawn(boolean b) {
		this.boundingBoxIsDrawn = b;
	}

	public int getBoundingBoxWidth() {
		int w = 0;
		for (Figure f : members) {
			int nw = f.getX() + f.getBoundingBoxWidth();
			if (nw > w) {
				w = nw;
			}
		}
		return w;
	}
	
	public int getBoundingBoxHeight() {
		int h = 0;
		for (Figure f : members) {
			int nh = f.getY() + f.getBoundingBoxWidth();
			if (nh > h) {
				h = nh;
			}
		}
		return h;
	}	
	
	public String toString(int level) {
		String s = super.toString(level);
		for (Figure f : members) {
			s = s + "\n" + f.toString(level+1);
		}
		return s;
	}
	
	public void paint(Graphics gc) {
		for (Figure f : members) {
			f.paint(gc);
		}
		
		if (isBoundingBoxDrawn()) {
			gc.setColor(Color.MAGENTA);
			gc.drawRect(getAbsX(), getAbsY(), getBoundingBoxWidth(), getBoundingBoxHeight());
		}
	}		

	//
	//Tree
	//
	public Object getChild(Object parent, int index) {
		if (this == parent) {
			return members.get(index);			
		} 
		
		return ((Group)parent).getChild(parent, index);
	}

	@Override
	public int getChildCount(Object parent) {
		if (this == parent) {
			return members.size();			
		} 
		
		return ((Group)parent).getChildCount(parent);
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (this == parent) {
			return members.indexOf(child);
		} 
		
		return ((Group)parent).getIndexOfChild(parent, child);
	}
	
	@Override
	public boolean isLeaf(Object o) {
		if (this == o) {
			return false;
		}
		return ((Figure)o).isLeaf(o);
	}	

}
