package com.example.election.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Voter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long voterId;
	
	private String fistName;
	
	private String lastName;
	
	private int nic;
	
	private int contactNo;
	
	Boolean isvoted;

	public Long getVoterId() {
		return voterId;
	}

	public void setVoterId(Long voterId) {
		this.voterId = voterId;
	}

	

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNic() {
		return nic;
	}

	public void setNic(int nic) {
		this.nic = nic;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public Boolean getIsvoted() {
		return isvoted;
	}

	public void setIsvoted(Boolean isvoted) {
		this.isvoted = isvoted;
	}

	
}
