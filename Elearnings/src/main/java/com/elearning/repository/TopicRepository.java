package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

	
	 @Query("SELECT t FROM Topic t WHERE t.topicName = :topicName")
	    Topic findByTopicName(@Param("topicName") String topicName);

	 @Query("SELECT tt FROM Topic tt WHERE tt.chapters.ChapterId = :chapterId")
	 List<Topic> findByTopicWiseChapterId(@Param("chapterId") long chapterId);




}