package ChainOfResponsibility.Aufgabe;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Search {
	
	public void handle(String search) {
		if(GUI.getButton(0)) {
			browse("https://www.google.com/search?q=" + search);
		}
		if(GUI.getButton(1)) {
			browse("https://docs.oracle.com/javase/7/docs/api/java/lang/" + search + ".html");
		}
	}
	
	public void browse(String search){
		try {
            Desktop.getDesktop().browse(new URI(search));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
	}
}
