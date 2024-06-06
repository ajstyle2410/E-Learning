package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.PracticeTest;

public interface PracticeTestRepository extends JpaRepository<PracticeTest, Long> {

}
