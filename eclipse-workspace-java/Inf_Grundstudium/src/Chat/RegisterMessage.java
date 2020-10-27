package Chat;

public class RegisterMessage extends Message {
	private static final long serialVersionUID = 2134663692L;
	
	public RegisterMessage (User user) {
		super (user);
	} 
	 
	public String toString () {
		return  "Register " + getUser();
	} 
} 