package com.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.TopicDTO;
import com.elearning.model.Chapter;
import com.elearning.model.Topic;
import com.elearning.repository.ChapterRepository;
import com.elearning.repository.TopicRepository;

@Service
public class TopicService implements TopicServiceInterface {

	@Autowired
	public TopicRepository topicRepository;

	@Autowired
	public ChapterRepository chapterRepo;

	@Override
	public String addTopics(TopicDTO topic) {
		try {
			long chapterId = topic.getChapterId();
			Topic tp = new Topic();
			Chapter chapter = chapterRepo.findById(chapterId).get();

			tp.setTopicName(topic.getTopicName());
			tp.setChapters(chapter);
			topicRepository.save(tp);
			return "Topic Added";
		} catch (Exception e) {

			System.out.println("Topic  Repository:" + e);

			return "Topic Not Added";
		}

	}

	@Override
	public Topic findByTopicRecords(String topicName) {

		Topic topic = topicRepository.findByTopicName(topicName);
		return topic;
	}

	@Override
	public List<Topic> viewChapterWiseSTopics(long chapterId) {

		
		return topicRepository.findByTopicWiseChapterId(chapterId);
	}

}
