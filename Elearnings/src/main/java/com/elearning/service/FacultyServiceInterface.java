package com.elearning.service;

import java.util.List;

import com.elearning.dto.FacultyProfileDTO;
import com.elearning.model.FacultyProfile;

public interface  FacultyServiceInterface {

	public String addFaculty(FacultyProfileDTO facultyProfileDTO);

	public List<FacultyProfile> findFaculty();

}
