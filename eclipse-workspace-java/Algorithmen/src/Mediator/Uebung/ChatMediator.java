package Mediator.Uebung;


/**
 * @author mustafa
 * @version v1.0
 */

public interface ChatMediator {
	
	public void sendMessage(String msg, User user);
	
	void addUser(User user);
}
