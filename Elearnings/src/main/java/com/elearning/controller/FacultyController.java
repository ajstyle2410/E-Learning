package com.elearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.FacultyProfileDTO;
import com.elearning.model.FacultyProfile;
import com.elearning.service.FacultyServiceInterface;

@RestController
public class FacultyController {
	
	@Autowired
	   public  FacultyServiceInterface facultyService ;

	  @PostMapping("addfaculty")
	   public ResponseEntity<String> addFaculty(@RequestBody  FacultyProfileDTO facultyProfileDTO)
	   {
		  String msg=	  facultyService.addFaculty(facultyProfileDTO);
		  
		  return  new ResponseEntity<String>(msg+"  Faculty Added...", HttpStatus.ACCEPTED);
	   }
	  
	   @GetMapping("showfaculty")
	    public   List<FacultyProfile>  showFaculty()
	    {
		             List<FacultyProfile> faculty = new ArrayList<FacultyProfile>();             
		  
		             return   facultyService.findFaculty();
	    }
}
