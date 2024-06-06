package com.elearning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AdminId;
	private String AdminName;
	private String Name;
	private String Password;
	private long ContactNumber;
	private String Email;

	public Admin(String adminName, String name, String password, long contactNumber, String email) {
		super();
		AdminName = adminName;
		Name = name;
		Password = password;
		ContactNumber = contactNumber;
		Email = email;
	}

}
