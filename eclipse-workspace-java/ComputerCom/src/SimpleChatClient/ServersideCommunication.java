/* --------------------------------
     ServersideCommunication.java
   -------------------------------- */


/*  Computerkommunikation & Verteilte Systeme 2016/2017, Rene Pawlitzek, NTB  */


/*  this class provides communication capabilities for a TCP server  */


package SimpleChatClient;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServersideCommunication {

	
	private  Socket  socket;
	
	
	public ServersideCommunication (Socket socket) {
		this.socket = socket;
	} // serversideCommunication
		
	
	public void sendMessage (Message message, Socket socket) {
	  try {
		  ObjectOutputStream outToClient = new ObjectOutputStream (socket.getOutputStream ());
		  outToClient.writeObject (message);
		  outToClient.flush ();
	  } catch (Exception e) {
	  	// e.printStackTrace ();
	  } // try
	} // sendMessage


	public Message getMessage () {
		try {
		  ObjectInputStream inFromClient = new ObjectInputStream (socket.getInputStream ());
		  Message message = (Message) inFromClient.readObject ();
		  return message;
		} catch (Exception e) {
			return null;
		} // try
	} // getMessage	
	
	
	public void close () {
		if (socket != null)
			try { socket.close (); } catch (Exception e) { } // try
	} // close
	
	
} // ServersideCommunication



/* ----- End of File ----- */
