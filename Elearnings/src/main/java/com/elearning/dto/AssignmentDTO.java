package com.elearning.dto;

import com.elearning.model.Assignment;
import com.elearning.model.Topic;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "topic_id", nullable = false)
	    private Topic topic;

		public AssignmentDTO(String question, String description, String type, Topic topic) {
			super();
			Question = question;
			Description = description;
			Type = type;
			this.topic = topic;
		}
	    
	    
}