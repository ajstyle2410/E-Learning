package com.elearning.model;

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
@Entity
@NoArgsConstructor
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long AssignmentId;
	@Column(columnDefinition = "TEXT") 
	private String Question;
	@Column(columnDefinition = "TEXT")
	 private String Description;
	 private String Type;
	
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "topic_id", nullable = false)
	    private Topic topic;

		public Assignment(String question, String description, String type, Topic topic) {
			super();
			Question = question;
			Description = description;
			Type = type;
			this.topic = topic;
		}
	    
	    
}
