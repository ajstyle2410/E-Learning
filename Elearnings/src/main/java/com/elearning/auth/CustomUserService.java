package com.elearning.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.elearning.model.UserProfile;
import com.elearning.repository.UserProfileRepository;

public class CustomUserService implements UserDetailsService {

	@Autowired
	 public UserProfileRepository userProfileRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserProfile user = userProfileRepository.findByEmail(username);
		
		
		  if(user==null)
		  {
			  throw new UsernameNotFoundException("Email not found");
		  }
		
		return new CustomUserDetail(user);
	}

}
