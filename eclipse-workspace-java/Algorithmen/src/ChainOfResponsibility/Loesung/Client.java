package ChainOfResponsibility.Loesung;

public class Client {
	
	static Handler[] h;
	
	public static void main(String[] args) {
		GUI.instantiate();
		
		h = new Handler[GUI.buttons.length];
		h[0] = new google();
		h[1] = new javaAPI();
		
		h[0].setNext(h[1]);
	}
	
	public static void guiRequest(String search) {
		h[0].handle(search);
	}
}