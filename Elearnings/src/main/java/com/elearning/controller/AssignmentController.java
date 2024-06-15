package com.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.AssignmentDTO;
import com.elearning.service.AssignmentServiceInterface;

@RestController
@RequestMapping("/api/assignments/")
public class AssignmentController {

	@Autowired
	public AssignmentServiceInterface assignmentServiceInterface;

	@PostMapping("addAssignments")
	public ResponseEntity<String> addAssignments(@RequestBody AssignmentDTO assignmentDTO) {
  
	   System.out.println(assignmentDTO.toString());	
	   
		String msg = assignmentServiceInterface.addAssignments(assignmentDTO);

		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

	}

}
