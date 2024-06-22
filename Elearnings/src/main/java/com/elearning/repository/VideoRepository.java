package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.model.Chapter;
import com.elearning.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

	@Query("SELECT c FROM Chapter c WHERE c.course.courseId = :cid")
	List<Chapter> findByCourseWiseId(@Param("cid") Long cid);

	@Query("SELECT v FROM Video v WHERE v.topic.topicId = :topicId")
	Video findTopicwiseVideo(@Param("topicId") long topicId);
}
