package com.example.election.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.election.model.User;
import com.example.election.repository.*;
import com.example.election.service.UserService;;

@Controller
public class HomeController {
	@Autowired
	userRepo userRepo;
	
	@Autowired
	UserService userServ;
	
	@RequestMapping("/")	
	public String home() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(User user,Model model ) {
		if(userRepo.findByNameAndPassword(user.getName(), user.getPassword())== null) {
			model.addAttribute("error","Enter valid Password & Username");
			return "login";
			
		}
		model.addAttribute("sucess", (userRepo.findByNameAndPassword(user.getName(), user.getPassword()).getName()));
		
		return"login";
		
		
	}
	
	
	}


