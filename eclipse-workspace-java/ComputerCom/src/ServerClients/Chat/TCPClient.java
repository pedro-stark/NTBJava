/* ------------------
     TCPClient.java
   ------------------ */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


/*  Echo Client mit TCP und Message Serialisierung!  */


package ServerClients.Chat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class TCPClient {
	
	
	private final static int     port = 9876;
	private final static String  targetHostname = "localhost";	
	
	
	public static void main (String argv[]) throws Exception {
		
		String  sentence;
		
		System.out.println ("TCPClient starting ...");
		
  	// Benutzereingabe abfragen
  	System.out.print ("Input: ");
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader (System.in));
		sentence = inFromUser.readLine ();
		
		// Socket für TCP Kommunikation erzeugen
		Socket clientSocket = new Socket (targetHostname, port);
		
		// Input und Output Stream fuer Objekte aufsetzen
		ObjectOutputStream outToServer =                               //  !
			new ObjectOutputStream (clientSocket.getOutputStream ());    //  !
		ObjectInputStream inFromServer =                               //  !
 			new ObjectInputStream (clientSocket.getInputStream ());      //  !
		
		// Benutzereingabe in Message verpacken und an Server schicken
		Message msg = new Message (sentence);
		outToServer.writeObject (msg);                                 //  !
		
		// Message von Server empfangen und ausgeben
		msg = (Message) inFromServer.readObject ();                    //  !
    System.out.println ("Answer from Server: " + msg.getText ());
		
		// Socket schliessen
    clientSocket.close ();
    
		System.out.println ("TCPClient finished.");
		
	} // main
} // TCPClient


/* ----- End of File ----- */
