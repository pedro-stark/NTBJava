
public class HueClient {

	private HueBridge hueBridge;
	
	public HueClient() {
		hueBridge = new HueBridge("http://192.168.0.13/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/");
		hueBridge.start();
		//hueBridge.setPoliceMode(2);
		hueBridge.setLampColorWheel(2);
		//hueBridge.setLampOn(2, true);
	}

	public static void main(String args[]){
		HueClient client = new HueClient();
	}
	
}
