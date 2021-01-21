package Mediator.Uebung;


/**
 * @author mustafa
 * @version v1.0
 */

public class UserImpl extends User {
	public UserImpl(ChatMediator med, String name){
		super(med, name);
	}
	@Override
	public void send(String msg){
		mediator.sendMessage(msg, this);
	}
	@Override
	public void receive(String msg){
		System.out.println(this.name + " received: " + msg);
	}
}
