package com.elearning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class UserProfile {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "user_profile_id")
	  private long UserProfileId;
	  private String Name;
	  private long MobileNumber;
	  private String Email;
	  private  String Password;
	  private String RegistrationDate;
	  private int Enabled;
	  private String Role;
	public UserProfile(String name, long mobileNumber, String email, String password, String registrationDate,
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

	@OneToOne(mappedBy = "userProfile")
	 private  UserCourse userCourse;
	  
}
