package KW48.u3_3;

import java.util.*;

public class MySortedList<T extends Comparable<T>> {
	
	private ArrayList<T> liste;
	
	public MySortedList() {
		liste = new ArrayList<>(); 
	}
	
	public void add(T t) {
		liste.add(t);
		Collections.sort(liste);
	}

	public void elementChanged(T t) {
		Collections.sort(liste);
	}
	
	public String toString() {
		return liste.toString();
	}
}
