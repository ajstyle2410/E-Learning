package com.elearning.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class FacultyProfileDTO {

 

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(columnDefinition = "TEXT")
    private MultipartFile profilePhoto;

    @Column(columnDefinition = "TEXT")
    private String designation;

    private String qualification;

    @Column(name = "skill_set")
    private String skillSet;

    @Column(name = "experience")
    private String experience;

    private long   courseId;

    public FacultyProfileDTO(String facultyName, MultipartFile profilePhoto, String designation, String qualification,
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