/* ----------------
     Message.java
   ---------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleChatClient;


import java.io.Serializable;


public class Message implements Serializable {

	public static final int  Posting    = 1;
	public static final int  Register   = 2;
	public static final int  Unregister = 3;
	
	private static final long serialVersionUID = -2645234121515049755L;
	
	private int    cmd;
	private String user;
	private String text;
	
	public Message (int cmd, String user, String text) {
		this.cmd = cmd;
		this.user = user;
		this.text = text;
	} // Message
	
	public int getCommand () {
		return cmd;
	} // getCommand
	
	public String getUser () {
		return user;
	} // getUser
	
	public String getText () {
		return text;
	} // getText
	
	public String toString () {
		if (cmd == Posting)
		  return user + ": " + text;
		else if (cmd == Register)
			return "Register " + user;
		else if (cmd == Unregister) 
			return "Unregister " + user;
		return "Unknown message command";
	} // toString

} // Message


/* ----- End of File ----- */