package com.elearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long FeedBackId;
	 private String Name;
	 private String Email;
	 private long ContactNumber;
	 @Column(columnDefinition = "TEXT")
	 private String Comment;
	 
}
