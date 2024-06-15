package com.elearning.dto;

import com.elearning.model.Topic;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssignmentDTO {

	@Column(columnDefinition = "TEXT")
	private String Question;
	@Column(columnDefinition = "TEXT")
	private String Description;
	private String Type;

	private Integer  topicId;

	public AssignmentDTO(String question, String description, String type, Integer  topic) {
		super();
		Question = question;
		Description = description;
		Type = type;
		this.topicId = topic;
	}

}