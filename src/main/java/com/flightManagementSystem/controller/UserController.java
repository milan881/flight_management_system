package com.flightManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightManagementSystem.repository.UserRepositries;

@Controller
public class UserController {

	@Autowired
	UserRepositries userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "/login/login";	
	}
	
	@RequestMapping("/showReg")
	public String User() {
		
		return "/login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") com.flightManagementSystem.entity.User user) {
			 userRepo.save(user);
		return "/login/login";	
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password,ModelMap model) {
	
		com.flightManagementSystem.entity.User user = userRepo.findByEmail(emailId);
		
		if(user!=null) {
			
		if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
				return "findFlights";
			}else {
				model.addAttribute("error", "Invalid Email or Password");
				return "/login/login";
			}
		}else {
			model.addAttribute("error", "Invalid Email or Password");
			return "/login/login";
		}
	}
	
}
