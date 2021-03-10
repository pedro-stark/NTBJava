/* ----------------
     Message.java
   ---------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package ServerClients.Chat;

import java.io.Serializable;


public class Message implements Serializable {
	
	private static final long serialVersionUID = -2645234121515049755L;

	private String text;
	
	public Message (String text) {
		this.text = text;
	} // Message
	
	public String getText () {
		return text;
	} // getText

} // Message


/* ----- End of File ----- */