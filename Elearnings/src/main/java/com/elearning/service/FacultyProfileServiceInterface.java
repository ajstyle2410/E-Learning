package com.elearning.service;

import java.util.List;

import com.elearning.dto.FacultyProfileDTO;
import com.elearning.model.FacultyProfile;

public interface  FacultyProfileServiceInterface {

	public String addFaculty(FacultyProfileDTO facultyProfileDTO);


	public List<FacultyProfile> viewAllFaculty();

}
