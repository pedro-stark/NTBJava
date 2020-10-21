import java.net.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Test extends TimerTask {

	URL url;
	int hue;
	int bri;
	boolean hellnachdunkel;
	boolean flash;

	public Test() throws IOException {

		// Init
		url = new URL("http://192.168.0.46/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/lights/2/state");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		hue = 44000;
		hellnachdunkel = false;
		flash = false;

		// Lampe einschalten
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		String jsonInputString = "{\"on\":true, \"sat\":255, \"bri\":255, \"hue\":" + hue + "}";
		try (java.io.OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
	}

	public void run() {

		// Farben im Kreis
		if (hue < 0 || hue > 65535) {
			hue = 0;
		}

		hue += 4000;
		
		// Helligkeit rauf und runter
		if (bri >= 245) {
			hellnachdunkel = true;
		} else if (bri <= 10) {
			hellnachdunkel = false;
		}

		if (hellnachdunkel) {
			bri -= 10;
		} else {
			bri += 10;
		}

		//Flashlight
//		if (flash) {
//			bri = 0;
//			flash = false;
//		} else {
//			bri = 255;
//			flash = true;
//		}
		
		
		//Helligkeit und Farbe
		try {
	//		changeColor(hue);
	//		changeBrightness(bri);
			changeColorAndBrightness(bri, hue);
		} catch (Exception e) {
			System.out.println(e);
			;
		}
		System.out.println("hue:" + hue + " | bri:" + bri);
	}

	public void changeColor(int hue /* , HttpURLConnection con */) throws IOException {
		String jsonInputString = "{\"hue\":" + hue + "}";
		url = new URL("http://192.168.0.46/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/lights/2/state");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json; utf-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		try (java.io.OutputStream os = conn.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
	}

	public void changeBrightness(int bri) throws IOException {
		String jsonInputString = "{\"bri\":" + bri + "}";
		url = new URL("http://192.168.0.46/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/lights/2/state");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json; utf-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		try (java.io.OutputStream os = conn.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
	}
	
	public void changeColorAndBrightness(int bri, int hue) throws IOException {
		String jsonInputString = "{\"bri\":" + bri + ", \"hue\":" + hue + "}";
		url = new URL("http://192.168.0.46/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/lights/2/state");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json; utf-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		try (java.io.OutputStream os = conn.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		Test test = new Test();
		Timer timer = new Timer();
		timer.schedule(test, 0, 500);
	}
}