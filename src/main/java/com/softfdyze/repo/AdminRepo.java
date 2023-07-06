package com.softfdyze.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softfdyze.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	public Admin findByusername(String username);
	
}
