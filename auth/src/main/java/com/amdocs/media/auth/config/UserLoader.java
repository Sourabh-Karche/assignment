package com.amdocs.media.auth.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amdocs.media.auth.dao.AuthDao;
import com.amdocs.media.auth.models.User;

@Component
public class UserLoader {
	
	private AuthDao authDao;
	
	@Autowired
	public UserLoader(AuthDao authDao) {
		this.authDao = authDao;
		this.loadUsers();
	}
	
	private void loadUsers() {
		User admin = this.populateUser(1, "admin", "password");
		User admin1 = this.populateUser(2, "admin1", "password");
		
		List<User> users = new ArrayList<User>();
 		users.add(admin);
 		users.add(admin1);
 		
 		for(User user: users) {
 			this.authDao.save(user);
 		}
	}
	
	private User populateUser(int userId, String username, String password) {
		User user = new User();
		user.setUserId(userId);
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	}

}
