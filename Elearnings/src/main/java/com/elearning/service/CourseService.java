package com.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.CourseDTO;
import com.elearning.model.Course;
import com.elearning.repository.CourseRepository;

@Service
public class CourseService implements CourseServiceInterface {

	@Autowired
	public CourseRepository courseRepository;
	@Override
	public String addCourse(CourseDTO course) {
		Course courses = new Course(course.getCourseName(), course.getFees(), course.getNoOfHours(), course.getBanner(),
				course.getObjective(), course.getPrerequisites(), course.getType(), course.getFacultyProfile());
		try {
			courseRepository.save(courses);
			return courses.getCourseName();
		} catch (Exception ex) {
		}
		
		return "No";
	}
	@Override
	public List<Course> viewCourse() {

    		return courseRepository.findAll();
		
	}

}
