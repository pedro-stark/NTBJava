
public class HueClient {

	private HueBridge hueBridge;
	
	public HueClient() {
		hueBridge = new HueBridge("http://192.168.0.10/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/");
		hueBridge.setLampOn(2, true);
		hueBridge.start();
		hueBridge.setPoliceMode(2);
		//hueBridge.setLampColorWheel(2);
	}

	public static void main(String args[]){
		HueClient client = new HueClient();
	}
	
}
