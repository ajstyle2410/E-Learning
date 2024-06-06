package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.Course;

public interface CourseRepository  extends JpaRepository<Course, Long>{

}
