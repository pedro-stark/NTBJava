package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class SwingDemo extends JFrame {
	JLabel result = new JLabel("...");

	public SwingDemo(){
		this.setTitle("SwingDemo");
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		cp.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("Dr�ck "));
		JButton button = new JButton("mich");
		panel.add(button);
		cp.add(result, BorderLayout.CENTER);
		
		button.addActionListener((e) -> {result.setText("Bingo"); });
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] arg) {
		new SwingDemo();
	}
}
