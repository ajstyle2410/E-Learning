package com.elearning.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedBackDTO {

	 private String Name;
	 private String Email;
	 private long ContactNumber;
	 @Column(columnDefinition = "TEXT")
	 private String Comment;
	 
}
