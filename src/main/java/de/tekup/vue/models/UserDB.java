package de.tekup.vue.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
	
	private static List<User> users;
	
	static {
		users = new ArrayList<>();
		users.add(new User(1, "John Doe", LocalDate.of(1999, 1, 3), "john@gmail.com"));
		users.add(new User(2, "user2", LocalDate.of(2001, 9, 11), "user2@gmail.com"));
	}
	
	public static List<User> getUsers(){
		return users;
	}
	
	public static void remove(int id) {
		users.removeIf(u -> u.getId()==id);
	}

}
