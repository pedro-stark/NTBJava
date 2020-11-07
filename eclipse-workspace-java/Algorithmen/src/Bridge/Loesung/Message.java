package Bridge.Loesung;

import javax.swing.JOptionPane;

public class Message implements Ausgabe{

	@Override
	public void print(String text) {
		JOptionPane.showMessageDialog(null,text);
	}
}
