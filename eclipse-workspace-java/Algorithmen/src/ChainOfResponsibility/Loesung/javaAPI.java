package ChainOfResponsibility.Loesung;

public class javaAPI extends BaseSearch{
	
	public void handle(String search) {
		if(GUI.getButton(1)) {
			super.browse("https://docs.oracle.com/javase/7/docs/api/java/lang/" + search + ".html");
		}
		
		super.handle(search);
	}
}
