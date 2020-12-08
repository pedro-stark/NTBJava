package src.CollectionsLoesung.u3_3_GenericClass;

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
