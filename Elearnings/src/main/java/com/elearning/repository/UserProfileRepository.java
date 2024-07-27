package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
     
	@Query("select e.Email from UserProfile e where e.Email=:Email ")
	public UserProfile findByEmail(@Param("Email")String Email);

}
