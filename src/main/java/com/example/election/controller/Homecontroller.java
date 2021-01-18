package com.example.election.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.election.model.Candidate;
import com.example.election.model.Voter;
import com.example.election.repository.CandidateRepo;
import com.example.election.repository.VoterRepo;

@Controller
public class Homecontroller {
	@Autowired
	VoterRepo voterRepo;
	
	@Autowired
	CandidateRepo candRepo;

	@RequestMapping("/")	
	public String home() {
		return "home";
	}
	
	@RequestMapping("/register")
	public String register(Voter voter) {
		return "register";
	}
	
	@GetMapping("/view")
	public String viewtable(Model model) {
		model.addAttribute("voter",voterRepo.findAll());
		return "view";
	}
	
	@RequestMapping("/delete")
	public String showdeletepage(Model model) {
		model.addAttribute("voter",voterRepo.findAll());
		return "delete";
	}
	
	
	@GetMapping("/remove/{id}")
	public String Delete(Model model,@PathVariable("id") Long id) {
		
		voterRepo.delete(voterRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid voter Id:" + id)));
		
		return"redirect:/delete";
	}
		
	@PostMapping("/update")
	public String addVoter( Voter voter, BindingResult result,Model model) {
	if (result.hasErrors()) {
			return "register";
				
				}
	
			voter.setIsvoted(false);
	   
		voterRepo.save(voter);
		String success_message="Success!!!You are Registered.";
		model.addAttribute("message", success_message);
		return "register";
		}
	
	@RequestMapping("/vote")	
	public String vote() {
		return "vote";
	}
	
	@RequestMapping("/findname")	
	public String findname(@RequestParam int nic,Model model,HttpSession session) {
		Voter voter=voterRepo.findByNic(nic);
		session.setAttribute("voter", voter);
		if(!voter.getIsvoted()) {
			
			List<Candidate >candidates=candRepo.findAll();
			model.addAttribute("candidates",candidates);
			model.addAttribute("name",voter.getFistName());
			return "candidateslist";
		}
		else {
		return "voted";
		}
	}
	
	
	@RequestMapping("/tovote{id}")
	public String votecount(@RequestParam int id, HttpSession session) {
		Voter voter1=(Voter)session.getAttribute("voter");
		voter1.setIsvoted(true);
		Candidate candidate=candRepo.findById(id);
		candidate.setVoteCount(candidate.getVoteCount()+1);
		candRepo.save(candidate);
		voterRepo.save(voter1);
		return"view";
	}
	
	
	
}
