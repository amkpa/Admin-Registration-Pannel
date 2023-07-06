package com.softfdyze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softfdyze.entity.Admin;
import com.softfdyze.repo.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo repo;
	
	public void save(Admin usr) {
	    if (usr.getUsername() == null || usr.getUsername().isEmpty()) {
	        throw new IllegalArgumentException("Username is required");
	    }

	    if (usr.getFirstName() == null || usr.getFirstName().isEmpty()) {
	        throw new IllegalArgumentException("First name is required");
	    }

	    if (usr.getLastName() == null || usr.getLastName().isEmpty()) {
	        throw new IllegalArgumentException("Last name is required");
	    }

	    // Validate other fields as needed...

	    Admin existingAdmin = repo.findByusername(usr.getUsername());
	    if (existingAdmin == null) {
	        repo.save(usr);
	    } else {
	        existingAdmin.setFirstName(usr.getFirstName());
	        existingAdmin.setLastName(usr.getLastName());
	        existingAdmin.setEmail(usr.getEmail());
	        existingAdmin.setPhone(usr.getPhone());
	        repo.save(existingAdmin);
	    }
	}

}
