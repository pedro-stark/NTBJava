package src.Patterns.MVC_3_JTable.v0.model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import src.Patterns.MVC_3_JTable.v0.model.*;
import src.Patterns.MVC_3_JTable.v0.view.MyWindow_JTable;

//Modell
public class Personenliste implements TableModel {
	// fuer das Observer-Pattern 
	private ArrayList<MyWindow_JTable> views;

	//fuer die Daten
	private ArrayList<Person> personen;

	
	public Personenliste() {
		personen = new ArrayList<Person>();
		views = new ArrayList<MyWindow_JTable>();
	}

	public void add(Person p) {
		personen.add(p);
		notifyViews();
	}

	public void remove(Person p) {
		personen.remove(p);
		notifyViews();
	}

	public String toString() {
		String s = "";
		for (Person p : personen) {
			s = s + "\n" + p.toString();
		}
		return s;
	}


	public void attach(MyWindow_JTable view) {
		views.add(view);
	}

	public void detach(MyWindow_JTable view) {
		views.remove(view);
	}

	public void notifyViews() {
		for (MyWindow_JTable v : views) {
			v.updateView();
		}
	}

	//
	//hier nun alle Methoden fuer das TableModel
	//
	@Override
	public void addTableModelListener(TableModelListener arg0) {
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
	public void removeTableModelListener(TableModelListener arg0) {
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
		notifyViews();
	}
}