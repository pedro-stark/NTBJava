package Bridge;

import javax.swing.*;

public class HelloWorldMessage extends TextAusgabe{
	
	public HelloWorldMessage() {
		super("HelloWorld!");
	}
	
	public void print() {
		JOptionPane.showMessageDialog(null,text);
	}
}
