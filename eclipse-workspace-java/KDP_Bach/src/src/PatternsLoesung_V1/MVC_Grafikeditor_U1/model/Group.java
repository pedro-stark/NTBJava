package src.PatternsLoesung_V1.MVC_Grafikeditor_U1.model;

import java.awt.Color;
import java.util.ArrayList;

public class Group extends Figure {
	protected ArrayList<Figure> members;

	public Group(int x, int y) {
		super(x, y, Color.WHITE);
		members = new ArrayList<>();
	}
	
	public void add(Figure f) {
		members.add(f);
		f.parent = this;
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
			int nh = f.getY() + f.getBoundingBoxHeight();
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
}
