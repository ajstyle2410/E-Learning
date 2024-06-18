package com.elearning.dto;

import java.util.Set;


import com.elearning.model.Assignment;
import com.elearning.model.InterviewQuestion;
import com.elearning.model.PracticeTest;
import com.elearning.model.Video;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class TopicDTO {



	private String topicName;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<InterviewQuestion> interviewQuestions;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<Assignment> assignments;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<Video> videos;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<PracticeTest> PracticeTest;
	

	
//	 @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
//	    private Set<Chapter> chapters;

	public TopicDTO(String topicName, Set<InterviewQuestion> interviewQuestions, Set<Assignment> assignments,
			Set<Video> videos, Set<com.elearning.model.PracticeTest> practiceTest) {
		super();
		this.topicName = topicName;
		this.interviewQuestions = interviewQuestions;
		this.assignments = assignments;
		this.videos = videos;
		PracticeTest = practiceTest;
	}
	

}
