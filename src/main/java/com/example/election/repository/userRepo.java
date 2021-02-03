package com.example.election.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.election.model.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {
	
	User findByNameAndPassword(String name, String password);

}
