package Prototype.Employee;

import java.util.ArrayList;
import java.util.List;

public class UserDetails implements Cloneable{
	private ArrayList<User> userList;
	
	public UserDetails() {
		this.userList=new ArrayList<>();
	}
	
	public UserDetails(ArrayList<User> users) {
		this.userList = users;
	}
	
	public void getUsers() {
		UserService s = new UserService();
		this.userList = s.getUsers();
	}
	
	public ArrayList<User> getUsersList(){
		return userList;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
			List<User> temp = new ArrayList<User>();
			for(User s : this.getUsersList()){
				temp.add(s);
			}
			return new UserDetails((ArrayList<User>) temp);
	}
}
