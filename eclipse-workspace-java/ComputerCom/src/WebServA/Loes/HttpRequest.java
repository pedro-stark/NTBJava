/* --------------------
     HttpRequest.java
   -------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


/*  
   Eine Instanz dieser Klasse repräsentiert und verarbeitet eine HTTP Anfrage. 
 
 */


package WebServA.Loes;


import java.io.*;
import java.net.*;


public class HttpRequest implements Runnable {
	
	
  private Socket  socket;
  
  
  public HttpRequest (Socket socket) throws Exception {
  	this.socket = socket;
  } // HttpRequest
  
  
  public void run () {
  	try {
  		processRequest ();
  	} catch (Exception e) {
  		e.printStackTrace ();
  	} // try
  } // run
  
  
  private void processRequest () throws Exception {
  	
  	// Eingabe- und Ausgabedatenstroeme festlegen bzw. abfragen
  	InputStreamReader is = new InputStreamReader (socket.getInputStream ());
  	DataOutputStream os = new DataOutputStream (socket.getOutputStream ());
  	
  	// Gepufferter Leser für Eingabe aufsetzen
  	BufferedReader br = new BufferedReader (is);
  	
  	// Erste Zeile der HTTP Anfrage abfragen
  	String requestLine = br.readLine ();
  	
  	// Erste Zeile der HTTP Anfrage ausgeben
  	if (requestLine != null) {
  	  System.out.println ();
  	  System.out.println (requestLine);
  	} // if
  	
  	// Alle weiteren Kopfzeilen der Anfrage abfragen und ausgeben
    String headerLine = br.readLine();
    while ((headerLine != null) && (headerLine.length() != 0)) {
    	System.out.println (headerLine);
    	headerLine = br.readLine ();
    } // while
  
    // Ein-/Ausgabedatenstroeme schliessen
    os.close ();
    br.close ();
    
    // Socket schliessen
    socket.close ();
  	
  } // processRequest
  
	
	
} // HttpRequest


/* ----- End of File ----- */