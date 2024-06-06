package com.elearning.dto;

import com.elearning.model.Chapter;
import com.elearning.model.FacultyProfile;
import com.elearning.model.UserCourse;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(columnDefinition = "TEXT")
    private String banner;

    @Column(columnDefinition = "TEXT")
    private String objective;

    @Column(columnDefinition = "TEXT")
    private String prerequisites;

    private String type;

    @OneToOne(mappedBy = "course")
    private FacultyProfile facultyProfile;
    
    
    @OneToOne(mappedBy = "course")
    private UserCourse userCourse;
    
    @OneToOne(mappedBy = "course")
    private Chapter chapter;

    public CourseDTO(String courseName, int fees, int noOfHours, String banner, String objective, String prerequisites,
                  String type, FacultyProfile facultyProfile) {
        super();
        this.courseName = courseName;
        this.fees = fees;
        this.noOfHours = noOfHours;
        this.banner = banner;
        this.objective = objective;
        this.prerequisites = prerequisites;
        this.type = type;
        this.facultyProfile = facultyProfile;
    }
}
