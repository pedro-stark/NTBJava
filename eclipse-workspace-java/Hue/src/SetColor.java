
/******************************************************************************/
/*                                                                            */
/*                                                        FILE: SetColor.java */
/*                                                                            */
/*       Demonstrates the HueBridge class                                     */
/*       ================================                                     */
/*                                                                            */
/*       V1.00    25-JAN-2018  Te          http://www.heimetli.ch             */
/*                                                                            */
/******************************************************************************/
import java.io.*;
import java.util.Timer;

/**
 * Sets the hue of a lamp on the Hue bridge.
 */
public class SetColor {
	/**
	 * Sets the hue of a lamp on the hue bridge.
	 *
	 * @param args The lamp and the hue for this lamp.
	 */
	public static void main(String[] args) {
//		if (args.length != 2) {
//			System.out.println("usage: java SetColor lamp hue");
//			return;
//		}

//		int lamp = 2;
//		int hue = 0;

//      try
//      {
//         lamp = Integer.parseInt( args[0] ) ;
//      }
//      catch( NumberFormatException e )
//      {
//         System.out.println( "error: lamp is not a valid number" ) ;
//         return ;
//      }

//		if ((lamp < 1) || (lamp > 2)) {
//			System.out.println("error: lamp is out of range");
//			return;
//		}

//      try
//      {
//         hue = Integer.parseInt( args[1] ) ;
//      }
//      catch( NumberFormatException e )
//      {
//         System.out.println( "error: hue is not a valid number" ) ;
//         return ;
//      }
		System.out.println("init hue bridge");
		HueBridge bridge = new HueBridge("http://192.168.0.46/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/");
		Timer timer = new Timer();
		timer.schedule(bridge, 0, 500);
		bridge.setLampColorWheel(2);
		//bridge.setLampOn(2, true);
		//bridge.setLampColor(2, 33420, 255);
		//bridge.setLampColorWheel(2);
	}
}
