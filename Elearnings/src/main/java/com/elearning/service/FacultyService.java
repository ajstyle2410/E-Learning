package com.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.FacultyProfileDTO;
import com.elearning.model.FacultyProfile;
import com.elearning.repository.FacultyProfileRepository;

@Service
public class FacultyService implements FacultyServiceInterface {

	@Autowired
	public FacultyProfileRepository facultyProfileRepository;

	@Override
	public String  addFaculty(FacultyProfileDTO facultyProfileDTO) {

		System.out.println("Faculty Service " + facultyProfileDTO.toString());

		FacultyProfile faculty = new FacultyProfile(facultyProfileDTO.getFacultyName(),
				facultyProfileDTO.getProfilePhoto(), facultyProfileDTO.getDesignation(),
				facultyProfileDTO.getQualification(), facultyProfileDTO.getSkillSet(),
				facultyProfileDTO.getExperience());

		  try {
		  facultyProfileRepository.save(faculty);
		      return  faculty.getFacultyName();
		  }catch(Exception ex)
		  {
			  
		  }
		  
		   return "No";
		  
	}

	@Override
	public List<FacultyProfile> findFaculty() {
		return facultyProfileRepository.findAll();
	}

}
