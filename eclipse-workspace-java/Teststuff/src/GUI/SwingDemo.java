package GUI;

import java.awt.*;
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
		panel.add(new JLabel("Drück "));
		JButton button = new JButton("mich");
		panel.add(button);
		cp.add(result, BorderLayout.CENTER);
		button.addActionListener(System.out::println);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] arg) {
		new SwingDemo();
	}
}
