package Bridge.Loesung;

public class Client {
	
	public static void main(String[] args) {
		printOhneBridge();
		
		printMitBridge();
	}
	
	public static void printOhneBridge() {
		/*
		TextAusgabe helloMessage = new HelloWorldMessage();
		TextAusgabe helloConsole = new HelloWorldConsole();
		
		helloMessage.print();
		helloConsole.print();*/
	}
	
	public static void printMitBridge() {
		Ausgabe console = new Console();
		Ausgabe message = new Message();
		Text hello = new HelloWorld(message);
		
		hello.print();
		
		hello.changeAusgabe(console);
		
		hello.print();
	}
}
