package com.elearning.dto;

import org.springframework.web.multipart.MultipartFile;

import com.elearning.model.Chapter;

import com.elearning.model.FacultyProfile;
import com.elearning.model.UserCourse;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

// please check the mapping    sending data purpose
@Data
@NoArgsConstructor

public class CourseDTO {

	@Column(name = "course_name")
	private String courseName;

	private int fees;
	

	@Column(name = "no_of_hours")
	private int noOfHours;

	private MultipartFile  banner;
	@Column(columnDefinition = "TEXT")
	private String objective;
	@Column(columnDefinition = "TEXT")
	
	private String Path;

	@Column(columnDefinition = "TEXT")
	private String prerequisites;

	private String type;



	public CourseDTO(String courseName, int fees, int noOfHours, MultipartFile banner, String objective, String path,
			String prerequisites, String type) {
		super();
		this.courseName = courseName;
		this.fees = fees;
		this.noOfHours = noOfHours;
		this.banner = banner;
		this.objective = objective;
		Path = path;
		this.prerequisites = prerequisites;
		this.type = type;

	}

	

}
