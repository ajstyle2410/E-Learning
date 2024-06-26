package com.elearning.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
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