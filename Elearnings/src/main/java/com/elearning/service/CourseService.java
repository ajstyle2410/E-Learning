package com.elearning.service;

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
		
		/*
		 *         Integer topicId = assignmentDTO.getTopicId();
        Topic topic = topicRepository.findById(topicId.intValue()).get();
		 * */
	
	
			
		Course courses = new Course(0, course.getCourseName(), course.getFees(), course.getNoOfHours(), course.getBanner().getOriginalFilename(),
				course.getObjective(), course.getPrerequisites(), course.getType(), course.getPath() );
		try {
			courseRepository.save(courses);
			return courses.getCourseName();
		} catch (Exception ex) {
		}
		
		return null;
	}
	@Override
	public List<Course> viewCourse() {

    		return courseRepository.findAll();
		
	}

}
