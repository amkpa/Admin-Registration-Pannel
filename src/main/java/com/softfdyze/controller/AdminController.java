package com.softfdyze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.softfdyze.entity.Admin;
import com.softfdyze.service.AdminService;

@Controller
public class AdminController {
	private AdminService service;
	
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@PostMapping("/save")
	public String addbook(@ModelAttribute Admin ad) {
		service.save(ad);
		return "redirect:/";
	}

}
