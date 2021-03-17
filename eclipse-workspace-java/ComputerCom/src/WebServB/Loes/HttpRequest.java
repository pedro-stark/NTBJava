/* --------------------
     HttpRequest.java
   -------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


/*  
   Eine Instanz dieser Klasse repräsensiert und verarbeitet eine HTTP Anfrage. 
 
 */


package WebServB.Loes;


import java.io.*;
import java.net.*;
import java.util.*;


public class HttpRequest implements Runnable {
	
	
	private static final String  CRLF = "\r\n";
	
	
  private Socket  socket;
  
  
  private static void sendBytes (FileInputStream fis, OutputStream os) throws Exception {
  	
  	int     bytes  = 0;
  	byte[]  buffer = new byte[1024];   // 1K Zwischenbuffer
  	
  	// Kopiert alle Bytes aus dem Dateieingabestrom in den Ausgabestrom
  	while ((bytes = fis.read (buffer)) != -1) {
  		os.write (buffer, 0, bytes);
  	} // while
  	
  } // sendBytes
  
  
  private static String getContentType (String fileName) {
  	// Bestimmt den Typ des Dateiinhalts aufgrund der Dateiendung
  	if (fileName.endsWith (".htm") || fileName.endsWith (".html")) {
  		return "text/html";
  	} // if
  	if (fileName.endsWith (".gif")) {
  		return "image/gif"
  				;
  	} // if
  	if (fileName.endsWith (".jpg") || fileName.endsWith (".jpeg")) {
  		return "image/jpeg";
  	} // if  	
  	return "application/octet-stream";
  } // getContentType
  
  
  public HttpRequest (Socket socket) throws Exception {
  	this.socket = socket;
  } // HttpRequest
  
  
  public void run () {
  	try {
  		processRequest ();
  	} catch (Exception e) {
  		// e.printStackTrace ();
  	} // try
  } // run
  
  
  private void processRequest () throws Exception { 
  	
  	InputStreamReader is = null;
  	DataOutputStream os = null;
  	BufferedReader br = null;
  	
  	try {
  	
	  	// Eingabe- und Ausgabedatenstroeme festlegen bzw. abfragen
	  	is = new InputStreamReader (socket.getInputStream ());
	  	os = new DataOutputStream (socket.getOutputStream ());
	  	
	  	// Gepufferter Leser für Eingabe aufsetzen
	  	br = new BufferedReader (is);
	  	
	  	// Erste Zeile der HTTP Anfrage abfragen
	  	String requestLine = br.readLine ();
	  	if (requestLine == null) 
	  		throw new Exception ();
	  	
	  	// Erste Zeile der HTTP Anfrage ausgeben
	  	System.out.println ();
	  	System.out.println (requestLine);
	  	
	  	// Alle weiteren Kopfzeilen der Anfrage abfragen und ausgeben
	    String headerLine = br.readLine();
	    while ((headerLine != null) && (headerLine.length() != 0)) {
	    	System.out.println (headerLine);
	    	headerLine = br.readLine();
	    } // while
	    
	    // Extrahiere den Dateinamen aus der Anfrage
	    StringTokenizer tokens = new StringTokenizer (requestLine);
	    // Erster Token (GET) überspringen
	    tokens.nextToken ();
	    // Dateiname abfragen
	    String fileName = tokens.nextToken ();
	    // Aktuelles Verzeichnis (.) vorne hinzufügen
	    fileName = "." + fileName;
	    
	    // Datei öffnen
	    FileInputStream fis = null;
	    boolean fileExists = true;
	    try {
	    	fis = new FileInputStream (fileName);
	    } catch (FileNotFoundException e) {
	    	fileExists = false;
	    } // try
	    
	    // dreiteilige Antwort erzeugen: http://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html
	    String statusLine = null;
	    String contentTypeLine = null;
	    String entityBody = null;
	    if (fileExists) {
	    	// Normalfall
	    	statusLine = "HTTP/1.0 200 OK";
	    	contentTypeLine = "Content-type: " + getContentType (fileName) + CRLF;
	    } else {
	    	// Fehlerfall
	    	// statusLine = "HTTP/1.0 404 Not Found";
	    	statusLine = "HTTP/1.0 200 OK";
	    	contentTypeLine = "Content-type: text/html" + CRLF;
	    	entityBody = "<HTML><HEAD><TITLE>Java WEBSERVER</TITLE></HEAD><BODY>This Page was made with JAVA</BODY></HTML>";
	    } // if
	     
	    // Statuszeile schicken
	    os.writeBytes (statusLine);
	    // Antworttyp schicken 
	    os.writeBytes (contentTypeLine);
	    // Leere Zeile schicken, um das Ende der Kopfzeilen zu signalisieren
	    os.writeBytes (CRLF);
	    // Antwort schicken
	    if (fileExists) {
	    	// Bytes der Datei schicken
	    	sendBytes (fis, os);
	    	// Datei schliessen
	    	fis.close ();
	    } else {
	    	// Fehlermeldung schicken
	    	os.writeBytes (entityBody);
	    } // if
  
  	} finally {
    
      // Ein-/Ausgabedatenstroeme schliessen
      os.close ();
      br.close ();
  
      // Socket schliessen
      System.out.println ("Closing socket");
      socket.close ();
      
  	} // try
  } // processRequest
	
	
} // HttpRequest


/* ----- End of File ----- */