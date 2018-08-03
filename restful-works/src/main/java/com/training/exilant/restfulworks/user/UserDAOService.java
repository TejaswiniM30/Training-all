package com.training.exilant.restfulworks.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	// we are simulation the DB
	// It is kept in the list

	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(101, "Rupa Jain", new Date()));
		users.add(new User(102, "Ankit kumar", new Date()));
		users.add(new User(103, "Akshay Mad", new Date()));
	}

	public List<User> getAllUsers() {
		return users;
	}

	int usersCount;

	public User saveUser(User user) {
		if (user.getUserId() == null) {
			user.setUserId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User getUser(int userId) {
		for (User user : users) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(int userId) {
		for (User user : users) {
			if (user.getUserId() == userId) {
				users.remove(users.indexOf(user));
				return user;
			}

		}

		return null;

	}

	public User updateUser(User user) {
		for(User u : users) {
			if(u.getUserId()==user.getUserId()) {
				u.setBirthDate(user.getBirthDate());
				u.setUserName(user.getUserName());
				return u;
			}
		}
		return null;
	}

}
