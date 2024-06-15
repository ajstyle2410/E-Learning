package com.elearning.dto;

import com.elearning.model.Topic;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class InterviewQuestionDTO {

    @Column(columnDefinition = "TEXT")
    private String question;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer  topicId;


	public InterviewQuestionDTO(String question, String description, Integer  topic) {
		super();
		this.question = question;
		this.description = description;
		this.topicId = topic;
	}
    
    
}
