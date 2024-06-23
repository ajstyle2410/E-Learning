package com.elearning.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearning.dto.CourseDTO;
import com.elearning.model.Course;
import com.elearning.repository.CourseRepository;
import com.elearning.repository.FacultyProfileRepository;

@Service
public class CourseService implements CourseServiceInterface {

	@Autowired
	public CourseRepository courseRepository;

	@Autowired
	public FacultyProfileRepository facultyProfileRepository;

	@Override
	public String addCourse(CourseDTO course) {

		System.err.println(course.toString());

		try {

			Course courses = new Course(course.getCourseName(), course.getFees(), course.getNoOfHours(),
					course.getBanner().getOriginalFilename(), course.getObjective(), course.getPrerequisites(),
					course.getType(), course.getPath());

			courseRepository.save(courses);
			return courses.getCourseName();
		} catch (Exception ex) {
			return null;
		}

	}

	@SuppressWarnings("unused")
	@Override
	public List<Course> viewCourse() {
		List<Course> list = new ArrayList<Course>();
		list = courseRepository.findAll();

		return list;

	}

	@Override
	public String deleteCourseById(long courseId) {
		  try {
		courseRepository.deleteById(courseId);
		
		 return courseId+" Delete id Successfully.........";
		  }catch (Exception e) {

		   System.out.println(e);
		  }
		return courseId+" Not deleted..........";
	}

}
