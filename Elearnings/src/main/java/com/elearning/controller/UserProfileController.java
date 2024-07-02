package com.elearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserProfileController {

	@GetMapping("user")
	 public ModelAndView userProfile()
	 {
		 return new ModelAndView("./user/UserDashboard");
	 }
	
}
