package Chat;

public class PostingMessage extends Message {
	private static final long serialVersionUID = -2645755L;
	
	private String text;
	
	public PostingMessage (User user, String text) {
		super (user);
		this.text = text;
	} 
	
	public String getText () {
		return text;
	} 
	
	public String toString () {
		return getUser() + ": " + text;
	} 

} 