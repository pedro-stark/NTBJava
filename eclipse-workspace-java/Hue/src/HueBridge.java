
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
import java.net.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.io.*;

/**
 * Sends commands to the Hue bridge.
 */

public class HueBridge extends TimerTask {
	private String baseURL;
	private String actualURL;
	private int state;
	// private ArrayList<Lamp> = new ArrayList<Lamp>();

	/**
	 * Sets the base url of the bridge.
	 *
	 * The base url is the part up to "lights".
	 */
	public HueBridge(String baseurl) {
		this.baseURL = baseurl;
		this.actualURL = baseurl;
	}

	/**
	 * Sends the given JSON string with the command for the given lamp to the
	 * bridge.
	 *
	 * @param lamp The number of the lamp
	 * @param json The command to send
	 */
	public void setLampState(String json) throws IOException, HueException {

		URL url = new URL(actualURL);
		HttpURLConnection connection = null;

		try {
			// JSON PUT REQUEST build
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");

			// send JSON
			OutputStreamWriter os = new OutputStreamWriter(connection.getOutputStream());

//			Write Variante 1
//  		try (java.io.OutputStream os = conn.getOutputStream()) {
// 			byte[] input = json.getBytes("utf-8");
// 			os.write(input, 0, input.length);
// 			}

			// Write Variante 2
			os.write(json);
			os.close();

			int state = connection.getResponseCode();
			if (state != HttpURLConnection.HTTP_OK)
				throw new HueException("Bridge returned state " + state);

			// Antwort von HUE Bridge REST API
			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());

				if (!response.toString().contains("success"))
					throw new HueException("Bridge returned an error: " + response.toString());
			}
		} finally {
			if (connection != null)
				connection.disconnect();
		}
	}

	public void setLampColor(int lamp, int hue, int bri) {
		actualURL = baseURL + "lights/" + lamp + "/state";
		String jsonInputString = "{\"sat\":255, \"bri\":" + bri + ", \"hue\":" + hue + "}";

		try {
			setLampState(jsonInputString);
		} catch (IOException | HueException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void setLampOn(int lamp, boolean lampSwitch) {
		actualURL = baseURL + "lights/" + lamp + "/state";
		String jsonInputString;

		if (lampSwitch) {
			jsonInputString = "{\"on\":true}";
		} else {
			jsonInputString = "{\"on\":false}";
		}

		try {
			setLampState(jsonInputString);
		} catch (IOException | HueException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void setLampColorWheel(int lamp) {
		state = 1; 

	}

	public void run() {
		
		//TODO durch alle Lampen durchiterieren, ONCHANGE PUT BEFEHL
		//TODO Methoden zur Farbänderung in Class Lamp?
		
		
		/**
		 * Hier wird der gewünschte Lichtstatus ausgewählt 
		 * 
		 * state default: do nothing
		 * 
		 * state 1: ColorWheel 
		 * 
		 * state 2: ColorBrightnessWheel
		 */
		switch (state) {
		case 1: //Colorwheel

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;

		default:
			// Do nothing
			break;
		}

	}
}
