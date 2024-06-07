package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.elearning.dto.CourseDTO;
import com.elearning.model.Course;
import com.elearning.service.CourseServiceInterface;

@RestController
public class CourseController {

	 @Autowired
	  public CourseServiceInterface courseServiceInterface; 
	 
	   public ResponseEntity<String> addCourse(@RequestBody CourseDTO course)
	   {
		      String msg = courseServiceInterface.addCourse(course);
		      
		    return new    ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	   }
	   
	   @GetMapping("courselist")
	   public List<Course>  viewCourse()
	   {
		   List  list = courseServiceInterface.viewCourse();
		return list;
	   }
}
