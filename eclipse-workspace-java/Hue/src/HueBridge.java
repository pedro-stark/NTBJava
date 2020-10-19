/******************************************************************************/
/*                                                                            */
/*                                                       FILE: HueBridge.java */
/*                                                                            */
/*       This class sends commands to the Hue bridge                          */
/*       ===========================================                          */
/*                                                                            */
/*       V1.00    25-JAN-2018  Te          http://www.heimetli.ch             */
/*                                                                            */
/******************************************************************************/
import java.net.* ;
import java.io.* ;
import javax.json.* ;

/**
 * Sends commands to the Hue bridge.
 */
public class HueBridge
{
   private String base ;

   /**
    * Sets the base url of the bridge.
    *
    * The base url is the part up to "lights".
    */
   public HueBridge( String baseurl )
   {
   	   base = baseurl ;
   }

   /**
    * Sends the given JSON string with the command for the
    * given lamp to the bridge.
    *
    * @param lamp The number of the lamp
    * @param json The command to send
    */
   public void setLampState( int lamp, String json ) throws IOException, HueException
   {
      URL url = new URL( base + "lights/" + lamp + "/state" ) ;

      HttpURLConnection connection = null ;
      
      try
      {
      	 connection = (HttpURLConnection)url.openConnection() ;
         connection.setDoOutput( true ) ;
         connection.setRequestMethod( "PUT" ) ;
         connection.setRequestProperty( "Content-Type", "application/json" ) ;

         OutputStreamWriter os = new OutputStreamWriter( connection.getOutputStream() ) ;
         os.write( json ) ;
         os.close();

         int status = connection.getResponseCode() ;
         
         if( status != HttpURLConnection.HTTP_OK )
            throw new HueException( "Bridge returned status " + status ) ;

         JsonReader reader = Json.createReader( connection.getInputStream() ) ;
	     JsonArray array = reader.readArray() ;
	     reader.close() ;

         JsonObject object = array.getJsonObject( 0 ) ;

         if( object.getJsonObject( "success") == null )
            throw new HueException( "Bridge returned an error: " + object ) ;
      }
      finally
      {
      	 if( connection != null )
      	 	 connection.disconnect() ;
      }
   }
}
