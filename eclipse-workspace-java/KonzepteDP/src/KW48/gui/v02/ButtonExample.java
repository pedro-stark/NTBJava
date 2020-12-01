package KW48.gui.v02;

import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends JFrame implements ActionListener {
	
    public ButtonExample() {
        super("Beispiel für Button");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JButton b = new JButton("Drück mich!");
        add(b);
        b.addActionListener(this);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)  {
        System.out.print("Der Button wurde gedrückt.");
        System.out.println(" Die Methode wird von " + Thread.currentThread().getName() + " ausgeführt.");
    }

    public static void main(String[] args)  {
        new ButtonExample();
    }
}