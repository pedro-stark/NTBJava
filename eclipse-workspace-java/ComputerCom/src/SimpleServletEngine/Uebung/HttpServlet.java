/* --------------------
     HttpServlet.java
   -------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleServletEngine.Uebung;


import java.io.IOException;


public abstract class HttpServlet {
	
	
	protected void init () throws ServletException {
	} // init
		
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} //doGet
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} // doPost
	
	
} // HttpServlet


/* ----- End of File ----- */
