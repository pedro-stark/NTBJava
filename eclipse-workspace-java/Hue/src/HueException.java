/******************************************************************************/
/*                                                                            */
/*                                                    FILE: HueException.java */
/*                                                                            */
/*       This class sends commands to the Hue bridge                          */
/*       ===========================================                          */
/*                                                                            */
/*       V1.00    25-JAN-2018  Te          http://www.heimetli.ch             */
/*                                                                            */
/******************************************************************************/

/**
 * A simple exception type for the Hue class.
 */
public class HueException extends Exception
{
   public HueException( String message )
   {
      super( message ) ;
   }
}