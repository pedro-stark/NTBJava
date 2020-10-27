package Chat;

public class UnregisterMessage extends Message {
	private static final long serialVersionUID = -67652348L;
	
	public UnregisterMessage (User user) {
		super (user);
	} 
	
	public String toString () {
		return "Unregister " + getUser();
	} 
	
} 