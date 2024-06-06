package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

}
