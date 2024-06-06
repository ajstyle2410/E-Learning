package com.elearning.model;

import java.util.Set;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id")
	private int topicId;

	private String topicName;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<InterviewQuestion> interviewQuestions;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<Assignment> assignments;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<Video> videos;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private Set<PracticeTest> PracticeTest;
	
	
	/*
	 *  @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "topic_id", nullable = false)
	    private Topic topic;*/
	
	 @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	    private Set<Chapter> chapters;

	public Topic(String topicName, Set<InterviewQuestion> interviewQuestions, Set<Assignment> assignments,
			Set<Video> videos, Set<com.elearning.model.PracticeTest> practiceTest) {
		super();
		this.topicName = topicName;
		this.interviewQuestions = interviewQuestions;
		this.assignments = assignments;
		this.videos = videos;
		PracticeTest = practiceTest;
	}
	

}
