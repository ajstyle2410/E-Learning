package com.elearning.service;


import java.util.List;

import com.elearning.dto.InterviewQuestionDTO;
import com.elearning.model.Chapter;

public interface InterviewQuestionServiceInterface {

	 public String addInterviewQuestion(InterviewQuestionDTO dto);

	public List<Chapter> finedCourseIdWiseRecords(long courseId);

}