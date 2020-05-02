package com.amdocs.media.auth.service;

import com.amdocs.media.auth.models.User;

public interface AuthService {
	public User getUser(User user);
	public User saveUser(User user);
}
