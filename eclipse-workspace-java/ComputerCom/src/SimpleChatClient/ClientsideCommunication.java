/* --------------------------------
     ClientsideCommunication.java
   -------------------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


/*  this class provides communication capabilities for a TCP client  */


package SimpleChatClient;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientsideCommunication {
	
	
	private  Socket  clientSocket;
	
	
	public void open (String targetHostname, int port) {
		try {
		  clientSocket = new Socket (targetHostname, port);
		} catch (Exception e) {
			e.printStackTrace ();
		} // try
	} // open
	
	
	public Message getMessage () {
		try {
		  ObjectInputStream inFromServer = new ObjectInputStream (clientSocket.getInputStream ());
		  Message message = (Message) inFromServer.readObject ();
		  return message;
		} catch (Exception e) {
			// e.printStackTrace ();
			return null;
		} // try
	} // getMessage
	
	
	public void sendMessage (Message message) {
		try {
		  ObjectOutputStream outToServer = new ObjectOutputStream (clientSocket.getOutputStream ());
	  	outToServer.writeObject (message);
	  	outToServer.flush ();
		} catch (Exception e) {
			e.printStackTrace ();
		} // try
  } // sendMessage	
	
	
	public void close () {
		if (clientSocket != null)
			try { clientSocket.close (); } catch (Exception e) { };
	} // close
	
	
} // ClientsideCommunication


/* ----- End of File ----- */
