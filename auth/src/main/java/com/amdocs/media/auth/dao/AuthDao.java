package com.amdocs.media.auth.dao;

import org.springframework.data.repository.CrudRepository;

import com.amdocs.media.auth.models.User;

public interface AuthDao extends CrudRepository<User, Integer>{
	public User findUserByUsernameAndPassword(String username, String password);
}
