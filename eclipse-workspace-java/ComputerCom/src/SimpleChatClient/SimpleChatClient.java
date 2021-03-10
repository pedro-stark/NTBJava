/* -------------------------
     SimpleChatClient.java
   ------------------------- */


/*  Simple chat client with TCP-based communication  */ 


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleChatClient;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class SimpleChatClient extends JFrame implements 
  ActionListener, WindowListener, Runnable, KeyListener {
	
	
	private static final  String  CRLF        = "\r\n";
	private static final  int     SERVER_PORT = 5555;
	private static final  String  SERVER_HOST = "localhost";
	
	
	private static final long serialVersionUID = -2937100503312197315L;
	
	
	private  JLabel       nameLabel        = new JLabel (" Name: ");
	private  JButton      sendButton       = new JButton ("Send");
	private  JButton      registerButton   = new JButton ("Register");
	private  JButton      unregisterButton = new JButton ("Unregister");
	private  JTextArea    messagesText     = new JTextArea ();
	private  JTextField   nameField        = new JTextField ();
	private  JTextField   messageField     = new JTextField ();
	private  JScrollPane  scrollPane       = new JScrollPane (messagesText);
	
	
	private  ClientsideCommunication  communication = new ClientsideCommunication ();    // this object enables client/server communication 
      

	public SimpleChatClient () {
		super ("NTB SimpleChatClient");
		
		// setup communication
		setup ();
		
		// setup buttons
		registerButton.setActionCommand ("Register");
		registerButton.addActionListener (this);
		unregisterButton.setActionCommand ("Unregister");
		unregisterButton.addActionListener (this);
		sendButton.setActionCommand ("Send");
		sendButton.addActionListener (this);
		
		// setup message field 
		messageField.addKeyListener (this);
		
		// create button panel
		JPanel buttonPanel = new JPanel (new BorderLayout ());
		buttonPanel.add (registerButton, BorderLayout.WEST);
		buttonPanel.add (unregisterButton, BorderLayout.EAST);		
		
		// create name panel
		JPanel namePanel = new JPanel (new BorderLayout ());
		namePanel.add (nameLabel, BorderLayout.WEST);
		namePanel.add (nameField, BorderLayout.CENTER);
		namePanel.add (buttonPanel, BorderLayout.EAST);
		namePanel.setBorder (new TitledBorder (" Register/Unregister "));

		// create messages panel
		JPanel messagesPanel = new JPanel (new BorderLayout ());
		messagesPanel.add (scrollPane, BorderLayout.CENTER);
		messagesPanel.setBorder (new TitledBorder (" Received Messages "));
		
		// create message panel
		JPanel messagePanel = new JPanel (new BorderLayout ());
		messagePanel.add (messageField, BorderLayout.CENTER);
		messagePanel.add (sendButton, BorderLayout.EAST);
		messagePanel.setBorder (new TitledBorder (" Send Message "));
		
		// create panel with name, messages and message panel
		JPanel panel1 = new JPanel (new BorderLayout ());
		panel1.add (namePanel, BorderLayout.NORTH);
		panel1.add (messagesPanel, BorderLayout.CENTER);
		panel1.add (messagePanel, BorderLayout.SOUTH);
		
    // create panel to hold all over panels
		JPanel contentPanel = new JPanel (new BorderLayout ());
		contentPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
		contentPanel.add (panel1, BorderLayout.CENTER);
				
		// add content panel to the window
		setContentPane (contentPanel);
		setPreferredSize (new Dimension (600, 400));
		addWindowListener (this);
		pack ();
		
		// show window
		setVisible (true);
		
	} // SimpleChatClient
	
	
	private void setup () {
		System.out.println ("Setup Chat Client");
		// open communication
		communication.open (SERVER_HOST, SERVER_PORT);
		// start a background thread to receive messages from the server
	  Thread thread = new Thread (this);
	  thread.start ();
	} // setup

	
	private void quit () {
		// quit the application
		System.out.println ("Quit Chat Client");
		unregister ();
		communication.close ();
		System.out.println ("Done.");
		System.exit (0);
	} // quit
	
	
	private void send () {
		// send the user message
		String user = nameField.getText ();
		String text = messageField.getText ();
		System.out.println (user + ": " + text);
		communication.sendMessage (new Message (Message.Posting, user, text));
		messageField.setText ("");
	} // send
	
	
	private void register () {
		// register the user
		String user = nameField.getText ();
		System.out.println ("Register " + user);
		communication.sendMessage (new Message (Message.Register, user, null));
	} // register
	
	
	private void unregister () {
		// unregister the user
		String user = nameField.getText ();
		System.out.println ("Unregister " + user);
		communication.sendMessage (new Message (Message.Unregister, user, null));
	} // unregister

	
	// ----- implementation of ActionListener interface -----
	

	public void actionPerformed (ActionEvent e) {
		String cmd = e.getActionCommand ();
		if ("Send".equals (cmd)) {
		  send ();
		} else if ("Register".equals (cmd)) {
			register ();
		} else if ("Unregister".equals (cmd)) {
			unregister ();
		} // if
	} // actionPerformed
	
	
	// ----- implementation of WindowListener interface -----


	public void windowActivated (WindowEvent arg0) {		
	} // windowActivated


	public void windowClosed (WindowEvent arg0) {	
	} // windowClosed

	
	public void windowClosing (WindowEvent arg0) {
		quit ();
	} // windowClosing


	public void windowDeactivated (WindowEvent arg0) {		
	} // windowDeactived
 

	public void windowDeiconified (WindowEvent arg0) {		
	} // windowDeiconified


	public void windowIconified (WindowEvent arg0) {		
	} // windowIconified


	public void windowOpened (WindowEvent arg0) {
	} // windowOpened
	
	
	// ----- implementation of Runnable interface -----

	
	public void run () { 
		while (true) {
			try {
		    // message was received
		    final Message message = communication.getMessage ();
			    if (message != null) {
				  // add the message text to the messages textarea
					Runnable appendText = new Runnable () {
						public void run () {
					    String user = message.getUser ();
					    String text = message.getText ();
						  messagesText.append (user + ": " + text);
						  messagesText.append (CRLF); 
						} // run
					};
					SwingUtilities.invokeLater (appendText);  // Swing is not thread-safe
		    } // if
		  } catch (Exception e) {
		  	// swallow all exceptions
		  } // try
	  } // while
	} // run	

	
	// ----- implementation of KeyListener interface ----- 
	

	public void keyPressed (KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			send ();
	} // keyPressed


	public void keyReleased (KeyEvent e) {		
	} // keyReleased


	public void keyTyped (KeyEvent e) {
	} // keyTyped
	
		
	// ----- main -----
	
	
	public static void main (String argv[]) {
		new SimpleChatClient ();
	} // main
	
	
} // SimpleChatClient


/* ----- End of File ----- */
