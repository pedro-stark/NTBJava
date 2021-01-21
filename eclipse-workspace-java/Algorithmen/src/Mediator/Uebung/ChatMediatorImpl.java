package Mediator.Uebung;

import java.util.*;

/**
 * @author mustafa
 * @version v1.0
 */

public class ChatMediatorImpl implements ChatMediator {
	private List<User> users;

	public ChatMediatorImpl() {
		this.users = new ArrayList<>();
	}

	@Override
	public void addUser(User user) {
		users.add(user);
		System.out.println(user.name + " has been added");
	}

	@Override
	public void sendMessage(String msg, User user) {
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User userr = (User) iterator.next();
				userr.receive(msg);				
		}
	}
}
