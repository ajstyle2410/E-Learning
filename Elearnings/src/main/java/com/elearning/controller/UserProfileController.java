package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.model.Course;
import com.elearning.model.UserProfile;
import com.elearning.service.CourseServiceInterface;

@RestController
public class UserProfileController {

	@Autowired
	private CourseServiceInterface courseServiceInterface;
	
	
	@GetMapping("user")
	 public ModelAndView userProfile()
	 {
		 return new ModelAndView("./user/UserDashboard");
	 }
	
	@GetMapping("/")
	 public ModelAndView  viewHomePage(ModelMap map)
	 {
		List<Course>  list = courseServiceInterface.viewCourse();
		
		map.addAttribute("list", list);
		
		
		return new ModelAndView("HomePage");
	 }
	
	  @PostMapping("userProfile")
	   public ModelAndView UserProfilerecords(@ModelAttribute("userProfile") UserProfile userProfile)
	   {
		   
		return null;
		   
	   }
}
