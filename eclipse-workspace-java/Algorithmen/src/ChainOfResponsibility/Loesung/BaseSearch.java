package ChainOfResponsibility.Loesung;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class BaseSearch implements Handler{
	
	protected Handler next;
	
	public void setNext(Handler h) {
		next = h;
	}
	
	public void handle(String search) {
		if(next != null) {
			next.handle(search);
		}
	}
	
	public void browse(String search) {
		try {
            Desktop.getDesktop().browse(new URI(search));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
	}
}
