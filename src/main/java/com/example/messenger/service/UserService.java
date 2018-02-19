package com.example.messenger.service;

import com.example.messenger.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}