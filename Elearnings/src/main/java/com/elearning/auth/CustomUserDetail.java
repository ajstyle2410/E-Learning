package com.elearning.auth;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.elearning.model.UserProfile;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
          
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserProfile userProfile;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->userProfile.getRole());
	
	}

	@Override
	public String getPassword() {
		
		return userProfile.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userProfile.getName();
	}
	
	  
	  
}
