package com.elearning.service;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.CourseDTO;
import com.elearning.model.Course;
import com.elearning.model.FacultyProfile;
import com.elearning.model.Topic;
import com.elearning.repository.CourseRepository;
import com.elearning.repository.FacultyProfileRepository;

@Service
public class CourseService implements CourseServiceInterface {

	@Autowired
	public CourseRepository courseRepository;
	
	@Autowired
	 public  FacultyProfileRepository  facultyProfileRepository;
	
	
	@Override
	public String addCourse(CourseDTO course) {
	    System.err.println(course.toString());

  System.out.println("***********************************************");
		Course courses = new Course(course.getCourseName(), course.getFees(), course.getNoOfHours(), course.getBanner().getOriginalFilename(),
				course.getObjective(), course.getPrerequisites(), course.getType(), course.getPath() );
	
		System.err.println(courses.toString());

		 
		try {
			
			    
			courseRepository.save(courses);
			return courses.getCourseName();
		} catch (Exception ex) {
			return null;
		}
		
	
	}
	@Override
	public List<Course> viewCourse() {

    		return courseRepository.findAll();
		
	}

}
