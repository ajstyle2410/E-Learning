package com.elearning.dto;

import com.elearning.model.UserCourse;

import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class UserProfileDTO {


	  private String Name;
	  private long MobileNumber;
	  private String Email;
	  private  String Password;
	  private String RegistrationDate;
	  private int Enabled;
	  private String Role;
	public UserProfileDTO(String name, long mobileNumber, String email, String password, String registrationDate,
			int enabled, String role) {
		super();
		Name = name;
		MobileNumber = mobileNumber;
		Email = email;
		Password = password;
		RegistrationDate = registrationDate;
		Enabled = enabled;
		Role = role;
	}
	  
	  
	 private  Integer  userCourseId;
	  
}
