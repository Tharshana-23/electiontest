package com.example.election.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.election.model.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
	
	Candidate findById(int id);

}
