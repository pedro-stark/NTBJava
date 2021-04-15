/* --------------------------
     HelloWorldServlet.java
   -------------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package ch.ntb.inf.coko.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import ch.ntb.inf.coko.engine.HttpServlet;
import ch.ntb.inf.coko.engine.HttpServletRequest;
import ch.ntb.inf.coko.engine.HttpServletResponse;
import ch.ntb.inf.coko.engine.ServletException;


public class HelloWorldServlet extends HttpServlet {

	
	// How to use:  http://localhost:8080/HelloWorldServlet
	
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html");    // this servlet produces html output
		PrintWriter out = response.getWriter ();
		out.println ("<html>");
		out.println ("<head><title>Hello World!</title></head>");
		out.println ("<body>");
		out.println ("<h1>Hello World!</h1>");
		out.println ("</body>");
		out.println ("</html>");
	} // doGet


} // HelloWorldServlet


/* ----- End of File ----- */
