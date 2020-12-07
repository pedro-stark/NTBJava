package ChainOfResponsibility.Loesung;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.Base64;
import javax.swing.*;

public class GUI {
	private static GUI instance;
	static boolean[] buttons = {false,false}; //Buttons von oben nach unten
	
	private GUI() {
		initGUI();
	}
	
	public static void instantiate(){ 
        if (instance == null){ 
            instance = new GUI();
        } 
    }
	
	private void initGUI(){
        JFrame window = new JFrame("Search Engine");
        window.setLocation(400, 200);
        window.setMinimumSize(new Dimension(500, 200));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**********Menubar*********/
        JMenuBar mb = new JMenuBar();
        window.setJMenuBar(mb);
        
        JMenu special = new JMenu("Help");
        mb.add(special);
        
        JMenuItem easteregg = new JMenuItem("Solution");
        special.add(easteregg);
        easteregg.addActionListener(ev -> easterEgg());
        
        /**********Content*********/
        Container contentPane = window.getContentPane();
        contentPane.setLayout(new GridLayout(1, 3, 20,100));
        
        JTextField eingabe = new JTextField("");
        
        JPanel auswahl = new JPanel(new GridLayout(2, 1));
        JRadioButton auswahl1 = new JRadioButton("Google");
        auswahl1.addActionListener( e->buttons[0] = !buttons[0]);
        auswahl.add(auswahl1);
        JRadioButton auswahl2 = new JRadioButton("Java API");
        auswahl2.addActionListener( e->buttons[1] = !buttons[1]);
        auswahl.add(auswahl2);
        
        JButton bearbeitung = new JButton("Search");
        bearbeitung.addActionListener(
        e-> Client.guiRequest(eingabe.getText()));
        
        // Packen aller Elemente
        contentPane.add(eingabe);
        contentPane.add(auswahl);
        contentPane.add(bearbeitung);
        
        window.pack();
        window.setVisible(true);
	}
	
	public static boolean getButton(int i) {
		return buttons[i];
	}
	
	private void easterEgg() {
		String importante = "aHR0cHM6Ly93d3cueW91dHViZS5jb20vd2F0Y2g/dj1kUXc0dzlXZ1hjUQ==";
        try {
            Desktop.getDesktop().browse(new URI(new String(Base64.getDecoder().decode(importante))));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
