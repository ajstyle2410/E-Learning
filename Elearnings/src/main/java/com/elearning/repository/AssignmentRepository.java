package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.Assignment;

public interface AssignmentRepository  extends JpaRepository<Assignment, Long>{

}
