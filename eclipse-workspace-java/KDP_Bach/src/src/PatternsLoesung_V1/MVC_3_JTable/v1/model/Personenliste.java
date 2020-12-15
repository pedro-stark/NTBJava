package src.PatternsLoesung_V1.MVC_3_JTable.v1.model;

import java.util.ArrayList;

import javax.swing.event.*;
import javax.swing.table.*;

import src.PatternsLoesung_V1.MVC_3_JTable.v1.view.MyWindow_JTable;

//Modell
public class Personenliste implements TableModel {
	// fuer das Observer-Pattern 
	private ArrayList<TableModelListener> views;

	//fuer die Daten
	private ArrayList<Person> personen;

	
	public Personenliste() {
		personen = new ArrayList<Person>();
		views = new ArrayList<TableModelListener>();
	}

	public void add(Person p) {
		personen.add(p);
		notifyViews(TableModelEvent.INSERT);
	}

	public void remove(Person p) {
		personen.remove(p);
		notifyViews(TableModelEvent.DELETE);
	}

	public String toString() {
		String s = "";
		for (Person p : personen) {
			s = s + "\n" + p.toString();
		}
		return s;
	}



	public void notifyViews(int kind) {
		for (TableModelListener l : views) {
			l.tableChanged(new TableModelEvent(this, kind));
		}
	}

	//
	//hier nun alle Methoden fuer das TableModel
	//
	@Override
	public void addTableModelListener(TableModelListener l) {
		views.add(l);
	}
	
	@Override
	public void removeTableModelListener(TableModelListener l) {
		views.remove(l);
	}	

	@Override
	public Class<?> getColumnClass(int index) {
		// 0: name, 1: vorname, 2: alter
		if (index == 2) {
			return Integer.class;
		} else {
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int index) {
		// 0: name, 1: vorname, 2: alter
		if (index == 0) {
			return "Name";
		} else if (index == 1) {
			return "Vorname";
		} else {
			return "Alter";
		}
	}

	@Override
	public int getRowCount() {
		return personen.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Person pAtRow = personen.get(row);
		// 0: name, 1: vorname, 2: alter
		if (col == 0) {
			return pAtRow.getName();
		} else if (col == 1) {
			return pAtRow.getVorname();
		} else {
			return pAtRow.getAlter();
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}

	@Override
	public void setValueAt(Object obj, int row, int col) {
		Person pAtRow = personen.get(row);
		if (col == 0) {
			pAtRow.setName((String)obj);
		} else if (col == 1) {
			pAtRow.setVorname((String)obj);
		} else {
			pAtRow.setAlter((Integer)obj);
		}
		notifyViews(TableModelEvent.UPDATE);
	}
}