package com.example.election.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.election.model.Voter;

public interface VoterRepo  extends JpaRepository<Voter,Long> {
	
	Voter findByNic(int nic);
	
	Voter findById(long id);

}
