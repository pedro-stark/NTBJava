package Mediator.Uebung;


/**
 * @author mustafa
 * @version v1.0
 */

public class Main {
	public static void main(String[] args){
		ChatMediatorImpl mediator = new ChatMediatorImpl();
		
		User user1 = new UserImpl(mediator, "user1");
		User user2 = new UserImpl(mediator, "user2");
		User user3 = new UserImpl(mediator, "user3");
		User user4 = new UserImpl(mediator, "user4");
		User user5 = new UserImpl(mediator, "user5");
		
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		mediator.addUser(user5);
		
		user1.send("Hello , Everyone");
		user5.send("mir geht es gut");
		
	}
}
