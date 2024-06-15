package com.elearning.dto;

import com.elearning.model.Course;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacultyProfileDTO {

 

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

    private long   courseId;

    public FacultyProfileDTO(String facultyName, String profilePhoto, String designation, String qualification,
                          String skillSet, String experience, long courseid) {
        super();
        this.facultyName = facultyName;
        this.profilePhoto = profilePhoto;
        this.designation = designation;
        this.qualification = qualification;
        this.skillSet = skillSet;
        this.experience = experience;
        this.courseId=courseid;
    }
    
}