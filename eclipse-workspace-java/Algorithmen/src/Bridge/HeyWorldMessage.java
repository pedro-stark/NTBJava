package Bridge;

import javax.swing.*;

public class HeyWorldMessage extends TextAusgabe{
	
	public HeyWorldMessage() {
		super("HeyWorld!");
	}
	
	public void print() {
		JOptionPane.showMessageDialog(null,text);
	}
}
