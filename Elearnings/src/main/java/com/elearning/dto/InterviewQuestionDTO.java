package com.elearning.dto;

import org.springframework.web.multipart.MultipartFile;

import com.elearning.model.Topic;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InterviewQuestionDTO {

    @Column(columnDefinition = "TEXT")
    private String question;

   //  private MultipartFile file;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer   topicId;

	public InterviewQuestionDTO(String question,  String description, Integer  topicId) {
		super();
		this.question = question;
		//this.file = file;
		this.description = description;
		this.topicId = topicId;
	}


	
    
}
