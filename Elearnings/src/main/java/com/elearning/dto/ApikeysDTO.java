package com.elearning.dto;


import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApikeysDTO {

	
	@Column(columnDefinition = "TEXT")
	  private String ApiKey;
}