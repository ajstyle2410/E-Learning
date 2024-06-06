package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
