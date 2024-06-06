package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.Video;

public interface VideoRepository  extends JpaRepository<Video, Long>{

}
