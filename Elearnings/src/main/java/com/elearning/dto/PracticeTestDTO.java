package com.elearning.dto;

import com.elearning.model.PracticeTest;
import com.elearning.model.Topic;

import jakarta.persistence.CascadeType;
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
public class PracticeTestDTO {


	private String Question;
	 private String Description;
	 private String Option1;
	 private String Option2;
	 private String Option3;
	 private String Option4;
	 private int Answer;
	
	   @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "topic_id", nullable = false)
	    private Topic topic;

	public PracticeTestDTO(String question, String description, String option1, String option2, String option3,
			String option4, int answer, Topic topic) {
		super();
		Question = question;
		Description = description;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		Answer = answer;
		this.topic = topic;
	}
	   
	
}
