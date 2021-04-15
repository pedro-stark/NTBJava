/* -----------------------
     MiniWebBrowser.java
   ----------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


/*  Quelle:  Java Swing, O'Reilly Inc., Page 880  */


package SimpleWebBrowser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class MiniWebBrowser extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 563275380787887432L;
	
	
	private  JLabel       statusBar;
	private  JTextField   urlField;
	private  JEditorPane  editor;
	
	
	public MiniWebBrowser (String startUrl) {
		super ("NTB Mini Web Browser");
		setSize (400, 300);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		// top and bottom panels
		JPanel urlPanel = new JPanel ();
		urlPanel.setLayout (new BorderLayout ());
		urlField = new JTextField (startUrl);
		urlField.addActionListener (this);
		JLabel label = new JLabel ("Site: ");
		urlPanel.add (label, BorderLayout.WEST);
		urlPanel.add (urlField, BorderLayout.CENTER);
		urlPanel.setBorder (new EmptyBorder (5, 5, 5, 5));
		statusBar = new JLabel (" ");
		statusBar.setBorder (new SoftBevelBorder (SoftBevelBorder.LOWERED));
		
		// center part
		editor = new JEditorPane ();
		editor.setContentType("text/html");
		editor.setEditable (false);
		try {
			editor.setPage (startUrl);
		} catch (Exception e) {
			statusBar.setText ("Unable to display page, using blank page instead.");
		} // try
		JScrollPane scroll = new JScrollPane (editor);
		scroll.setBorder (new EmptyBorder (5, 5, 5, 5));
		
		// put everything together
		JPanel panel = new JPanel ();
		panel.setLayout (new BorderLayout ());
		panel.add (urlPanel, BorderLayout.NORTH);
		panel.add (scroll, BorderLayout.CENTER);
		panel.add (statusBar, BorderLayout.SOUTH);
		getContentPane().add (panel);
		
	} // MiniWebBrowser


	/* ----- implementation of ActionListener interface ----- */
	

	public void actionPerformed (ActionEvent event) {
		try {
			editor.setPage (event.getActionCommand ());
		} catch (Exception e) {
			statusBar.setText ("Error: " + e.getMessage ());
		} // try
	} // actionPerformed
	
	
	public static void main (String args[]) {
		MiniWebBrowser browser = new MiniWebBrowser ("http://localhost:6789/index.html");
		browser.setVisible (true);
	} // main
	
	
} // MiniWebBrowser


/* ----- End of File ----- */
