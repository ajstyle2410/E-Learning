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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

	public InterviewQuestionDTO(String question, String description, Topic topic) {
		super();
		this.question = question;
		this.description = description;
		this.topic = topic;
	}
    
    
}
