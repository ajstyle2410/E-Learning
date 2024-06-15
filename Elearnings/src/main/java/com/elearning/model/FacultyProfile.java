package com.elearning.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class FacultyProfile {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private long facultyId;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(columnDefinition = "TEXT")
    private String profilePhoto;

    @Column(columnDefinition = "TEXT")
    private String designation;

    private String qualification;

    @Column(name = "skill_set")
    private String skillSet;

    @Column(name = "experience")
    private String experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

	public FacultyProfile(String facultyName, String profilePhoto, String designation, String qualification,
			String skillSet, String experience, Course course) {
		super();
		this.facultyName = facultyName;
		this.profilePhoto = profilePhoto;
		this.designation = designation;
		this.qualification = qualification;
		this.skillSet = skillSet;
		this.experience = experience;
		this.course = course;
	}



	
    
}
