package com.mmit.services;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Named;

@Named
public class UserService {

	private List<String> emails = List.of(
			"user1@gmail.com",
			"user2@gmail.com"
			);
	
	public boolean validateEmail(String email) {
		if(emails.contains(email))
			return true;
		
		return false;
	}

	public void save(String email, String password) {
		System.out.println("Save to database");
		
	}
}
