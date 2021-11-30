package de.tekup.vue.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
	
	private static List<User> users;
	
	static {
		users = new ArrayList<>();
		
		users.add(new User(1, "John Doe", "1234", LocalDate.of(1999, 1, 3), "john@gmail.com"));
		users.add(new User(2, "user2", "1234", LocalDate.of(2001, 9, 11), "user2@gmail.com"));
	}
	
	public static List<User> getUsers(){
		return users;
	}
	
	public static void remove(int id) {
		users.removeIf(u -> u.getId()==id);
	}
	public static void add(User user) {
		System.out.println(user);
		if(user.getId()==0)
			user.setId(users.size()+1);
		else
			remove(user.getId());
		users.add(user);
	}
	
	public static User get(int id) {
		return users.stream()
				.filter(u -> u.getId()==id)
				.findFirst().get();
	}

}
