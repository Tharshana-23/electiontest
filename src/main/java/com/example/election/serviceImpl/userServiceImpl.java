package com.example.election.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.election.model.User;
import com.example.election.repository.userRepo;
import com.example.election.service.UserService;
@Service
public class userServiceImpl implements UserService {
	
	@Autowired
	userRepo userRepo;

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		User user=userRepo.findByNameAndPassword(name, password);
		return user;
		
	}
	}


