package Chat;

import java.io.Serializable;

public abstract class Message implements Serializable {

	private static final long serialVersionUID = 7497897L;
	
	private User user;
	
	public Message (User user) {
	    this.user = user;
	}
	
	public User getUser () {
		return user;
	} 
} 