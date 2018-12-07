package com.vot.services;

import com.vot.model.User;

public interface UserService {
	public void save(User user);
	public User findByUsername(String username);
}
