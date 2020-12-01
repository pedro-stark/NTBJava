package KW48.gui.v02;

import java.awt.event.*;
import javax.swing.*;

public class ButtonExample extends JFrame implements ActionListener {
	
    public ButtonExample() {
        super("Beispiel f�r Button");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JButton b = new JButton("Dr�ck mich!");
        add(b);
        b.addActionListener(this);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)  {
        System.out.print("Der Button wurde gedr�ckt.");
        System.out.println(" Die Methode wird von " + Thread.currentThread().getName() + " ausgef�hrt.");
    }

    public static void main(String[] args)  {
        new ButtonExample();
    }
}