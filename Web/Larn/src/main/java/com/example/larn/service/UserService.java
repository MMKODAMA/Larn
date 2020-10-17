package com.example.larn.service;

import com.example.larn.model.User;

public interface UserService {
	public void saveUser(User user);
	
	public boolean isUserAlredyPresent(User user);
}
