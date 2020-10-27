package FIFA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class FifaGUI {
	
    private  JLabel       idLabel            = new JLabel (" SpielerID: ");
    private  JLabel       nameLabel          = new JLabel (" Name: ");
    private  JLabel       ageLabel           = new JLabel (" Alter: ");
    private  JLabel       clubLabel          = new JLabel (" Club: ");
    private  JLabel       nationLabel        = new JLabel (" Nation: ");
    
    private  JTextField   idField            = new JTextField ();
    private  JTextField   nameField          = new JTextField ();
    private  JTextField   ageField           = new JTextField ();
    private  JTextField   clubField          = new JTextField ();
    private  JTextField   nationField        = new JTextField ();
    
    private  JButton      nextPlayerButton   = new JButton("next Player");
    
    private  JPanel       GridlayoutPanel    = new JPanel();
    
    private  Thread		  runTime;
    

	public FifaGUI() {
		runTime = new Thread() {
            public void run () { 
                while (true) {
                	

                    }
                }
            };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
