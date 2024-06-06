package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.InterviewQuestion;

public interface InterviewQuestionRepository  extends JpaRepository<InterviewQuestion, Long>{

}
