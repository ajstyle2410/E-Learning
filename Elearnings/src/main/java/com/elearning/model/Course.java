package com.elearning.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private long courseId;

	@Column(name = "course_name")
	private String courseName;

	private int fees;

	@Column(name = "no_of_hours")
	private int noOfHours;

	@Column(columnDefinition = "TEXT")
	private String banner; // Changed to store file path

	@Column(columnDefinition = "TEXT")
	private String objective;

	@Column(columnDefinition = "TEXT")
	private String prerequisites;

	private String type;
	
	private String Path;

	@OneToOne(mappedBy = "course")
	private FacultyProfile facultyProfile;

	@OneToOne(mappedBy = "course")
	private UserCourse userCourse;

	@OneToOne(mappedBy = "course")
	private Chapter chapter;

	public Course( String courseName, int fees, int noOfHours, String banner, String objective,
			String prerequisites, String type, String path) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fees = fees;
		this.noOfHours = noOfHours;
		this.banner = banner;
		this.objective = objective;
		this.prerequisites = prerequisites;
		this.type = type;
		Path = path;

	}


}