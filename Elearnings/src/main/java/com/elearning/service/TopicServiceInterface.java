package com.elearning.service;

import java.util.List;

import com.elearning.dto.TopicDTO;
import com.elearning.model.Topic;

public interface TopicServiceInterface {
	
	public String addTopics(TopicDTO topic);

	public Topic findByTopicRecords(String topicName);

	public List<Topic> viewChapterWiseSTopics(long chapterId);



}
