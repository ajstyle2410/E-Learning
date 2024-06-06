package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
