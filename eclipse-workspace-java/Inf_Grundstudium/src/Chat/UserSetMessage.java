package Chat;

import java.util.*;

public class UserSetMessage extends Message {
	private static final long serialVersionUID = -2544455L;
	
	private Set<User> registeredUsers;
	
	public UserSetMessage (Set<User> registeredUsers) {
	    super (null);
		this.registeredUsers = registeredUsers;
	} 
	
	public Set<User> getUserSet () {
		return registeredUsers;
	} 
	
	public String toString () {
	    StringBuffer sb = new StringBuffer();
	    for (User u: registeredUsers) {
	        sb.append(u.getName());
	        sb.append(" ");
	    }
		return sb.toString();
	} 
	
} 