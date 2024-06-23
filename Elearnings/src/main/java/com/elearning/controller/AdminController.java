package com.elearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView viewAdminDashboard() {
        return new ModelAndView("admin");
    }
    
    
    @GetMapping("addcourse")
     public ModelAndView addCourse()
     {
    	return new ModelAndView("addCourse");
     }
    
    @GetMapping("showcourse")
    public ModelAndView showCourse()
    {
   	return new ModelAndView("showCourse");
    }
   
}
