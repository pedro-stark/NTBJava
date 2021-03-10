
public class HueClient {

	private HueBridge hueBridge;
	
	public HueClient() {
		hueBridge = new HueBridge("http://192.168.0.46/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/");
		hueBridge.start();
		//hueBridge.setLampColorWheel(2);
		hueBridge.setLampOn(1, true);
	}

	public static void main(String args[]){
		HueClient client = new HueClient();
	}
	
}
