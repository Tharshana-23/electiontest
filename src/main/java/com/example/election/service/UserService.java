package com.example.election.service;

import com.example.election.model.User;

public interface UserService {
	
	public User getUserByNameAndPassword(String name,String password);

}
