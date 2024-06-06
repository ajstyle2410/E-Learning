package com.elearning.model;

import jakarta.persistence.CascadeType;
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
public class UserCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long UserCourseId;
	
   
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	   private Course course;
	   
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="user_profile_id",referencedColumnName = "user_profile_id")
	    private UserProfile userProfile;


	public UserCourse(Course course, UserProfile userProfile) {
		super();
		this.course = course;
		this.userProfile = userProfile;
	}
	  
	  
	  
}
