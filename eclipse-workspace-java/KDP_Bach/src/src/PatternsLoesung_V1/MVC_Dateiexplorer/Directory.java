package src.PatternsLoesung_V1.MVC_Dateiexplorer;

import java.io.File;
import java.util.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Directory implements TableModel {
	private List<TableModelListener> observers;
	private File root;
	private File[] content;
	
	public Directory(String d) {
		observers = new ArrayList<>();
		setDirectory(d);
	}
	
	public String getCurrentDirectory() {
		return root.getAbsolutePath();
	}
	
	public String getParentOfCurrentDirectory() {
		return root.getParent();
	}

	public void setDirectory(String d) {
		try {
			File newFile = new File(d);
			if (newFile.isDirectory()) {
				root = newFile;
				content = root.listFiles();
				notifyObservers();
			}			
		} catch (Exception ex) {
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		observers.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		observers.remove(l);
	}
	
	public void notifyObservers() {
		for (TableModelListener l : observers) {
			l.tableChanged(new TableModelEvent(this));
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Name, Grösse, Änderungsdatum, IsDir, Absoluter Name
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return Integer.class;
			case 2: return Date.class;
			case 3: return Boolean.class;
			case 4: return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// Name, Grösse, Änderungsdatum
		switch (columnIndex) {
			case 0: return "Name";
			case 1: return "Grösse";
			case 2: return "Änderungsdatum";
			case 3: return "Verzeichnis?";
			case 4: return "Absolut";
		}
		return null;
	}

	@Override
	public int getRowCount() {
		return content.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= content.length) return null;
		// Name, Grösse, Änderungsdatum
		switch (columnIndex) {
			case 0: return content[rowIndex].getName();
			case 1: return content[rowIndex].length();
			case 2: return new Date(content[rowIndex].lastModified());
			case 3: return content[rowIndex].isDirectory();
			case 4: return content[rowIndex].getAbsolutePath();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		File f = new File(root.getAbsolutePath() + "/" + (String)aValue);
		content[rowIndex].renameTo(f);
		
		//refresh
		setDirectory(getCurrentDirectory());
	}
}
