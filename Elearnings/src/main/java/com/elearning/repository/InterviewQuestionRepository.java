package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.model.InterviewQuestion;

public interface InterviewQuestionRepository  extends JpaRepository<InterviewQuestion, Long>{

	@Query("select  i from InterviewQuestion i where  topic.topicId=:topicId")
	List<InterviewQuestion> viewInterviewQuestionByTopicId(@Param ("topicId") long topicId);
}
