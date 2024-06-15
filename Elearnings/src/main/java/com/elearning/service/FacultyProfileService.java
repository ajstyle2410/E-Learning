package com.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.FacultyProfileDTO;
import com.elearning.model.Course;
import com.elearning.model.FacultyProfile;
import com.elearning.repository.CourseRepository;
import com.elearning.repository.FacultyProfileRepository;

@Service
public class FacultyProfileService implements FacultyProfileServiceInterface {

	@Autowired
	public FacultyProfileRepository facultyProfileRepository;

	@Autowired
	public CourseRepository courseRepository;

	@Override
	public String addFaculty(FacultyProfileDTO facultyProfileDTO) {

		Long courseId = facultyProfileDTO.getCourseId();

		Course facultycourseid = courseRepository.findById(courseId).get();

		System.out.println("Faculty Service " + facultyProfileDTO.toString());

		FacultyProfile faculty = new FacultyProfile(facultyProfileDTO.getFacultyName(),
				facultyProfileDTO.getProfilePhoto(), facultyProfileDTO.getDesignation(),
				facultyProfileDTO.getQualification(), facultyProfileDTO.getSkillSet(),
				facultyProfileDTO.getExperience(), facultycourseid);

		try {
			facultyProfileRepository.save(faculty);
			return faculty.getFacultyName();
		} catch (Exception ex) {

		}

		return "No";

	}

	@Override
	public List<FacultyProfile> findFaculty() {
		return facultyProfileRepository.findAll();
	}

}
