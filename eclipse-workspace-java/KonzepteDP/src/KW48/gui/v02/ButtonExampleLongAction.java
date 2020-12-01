package KW48.gui.v02;

import java.awt.event.*;

public class ButtonExampleLongAction extends ButtonExample {
	
    public void actionPerformed(ActionEvent evt)  {
        super.actionPerformed(evt);
        try { Thread.sleep(10000); } catch(InterruptedException e) {}
        System.out.println("Lange Aktion wurde ausgeführt.");
    }

    public static void main(String[] args)  {
        new ButtonExampleLongAction();
    }
}