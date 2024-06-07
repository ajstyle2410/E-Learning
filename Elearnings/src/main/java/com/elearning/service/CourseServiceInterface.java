package com.elearning.service;

import java.util.List;

import com.elearning.dto.CourseDTO;
import com.elearning.model.Course;

public  interface  CourseServiceInterface {

  public	String addCourse(CourseDTO  course);

public  List<Course> viewCourse();


}
