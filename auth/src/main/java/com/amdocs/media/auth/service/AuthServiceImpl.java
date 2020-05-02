package com.amdocs.media.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.auth.dao.AuthDao;
import com.amdocs.media.auth.models.User;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDao authDao;
	
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return authDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return authDao.save(user);
	}
}
