package ChainOfResponsibility.Loesung;

public class google extends BaseSearch{
	
	public void handle(String search) {
		if(GUI.getButton(0)) {
			super.browse("https://www.google.com/search?q=" + search);
		}
		
		super.handle(search);
	}
}