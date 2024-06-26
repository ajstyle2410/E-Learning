package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.model.Assignment;

public interface AssignmentRepository  extends JpaRepository<Assignment, Long>{

	@Query("select  a from Assignment a where a.topic.topicId=:topicId")
	List<Assignment> findByTopicWiseAssignments(@Param("topicId")long topicId );

}
