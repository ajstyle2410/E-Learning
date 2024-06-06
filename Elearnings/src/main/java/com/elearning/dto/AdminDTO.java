package com.elearning.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDTO {
	private String AdminName;
	private String Name;
	private String Password;
	private long ContactNumber;
	private String Email;

	public AdminDTO(String adminName, String name, String password, long contactNumber, String email) {
		super();
		AdminName = adminName;
		Name = name;
		Password = password;
		ContactNumber = contactNumber;
		Email = email;
	}
}
