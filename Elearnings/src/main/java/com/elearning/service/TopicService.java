package com.elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.TopicDTO;
import com.elearning.model.Topic;
import com.elearning.repository.TopicRepository;
@Service
public class TopicService implements TopicServiceInterface{

	@Autowired
	 public TopicRepository topicRepository;
	
	@Override
	public String addTopic(TopicDTO topicDTO) {
		
		  Topic topic = new Topic(topicDTO.getTopicName(), topicDTO.getInterviewQuestions(), topicDTO.getAssignments(), topicDTO.getVideos(), topicDTO.getPracticeTest(), topicDTO.getChapters());
	
		   try {
		 topicRepository.save(topic);
		 return topic.getTopicName();
		   }catch (Exception e) {
			System.out.println(e);
		}
		 return "NO";
	}

}
