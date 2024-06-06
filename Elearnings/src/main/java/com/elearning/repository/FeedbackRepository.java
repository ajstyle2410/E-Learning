package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.FeedBack;

public interface FeedbackRepository  extends JpaRepository<FeedBack, Long>{

}
