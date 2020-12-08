package src.Zeichen;
import javax.swing.*;

public class Emojis {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("List of Emojis"); JTextArea t = new JTextArea();f.add(new JScrollPane(t));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); f.setSize(400, 600); f.setVisible(true);
		
		for (int i = 0x1F600; i <= 0x1F64F; i++) {
			//TODO
			String s = String.format("Codepoint %X; Name: %s; Symbol: %s\n", i, "to do", "to do");
			t.append(s);
		}

	}

}
