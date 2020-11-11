package Prototype.Employee;

import java.util.ArrayList;

public class UserService {
	ArrayList<User> users;
	
	public UserService() {
		users = new ArrayList<>();
		users.add(new User("Albert","albert@gmail.com"));
		users.add(new User("Bob","bob@gmail.com"));
		users.add(new User("Gary","gary@gmail.com"));
		users.add(new User("Geno","geno@gmail.com"));
	}
	public ArrayList<User> getUsers(){
		return users;
	}
}
