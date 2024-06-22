package com.elearning.service;


import com.elearning.model.Chapter;
import com.elearning.model.Topic;
import com.elearning.model.Video;
import com.elearning.repository.TopicRepository;
import com.elearning.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements VideoServiceInterface {

	@Autowired
	private VideoRepository videoRepository;

	 @Autowired
	 private TopicRepository topicRepository;
	
	@Override
	public String addVideo(Video video) {
		try {
			System.out.println(video.getTopic().getTopicName());
     System.err.println("I am Video Service  "+video.toString());
			videoRepository.save(video);
			return "Video added successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error adding video";
		}
	}

	@Override
	public List<Video> getVideos() {
		return videoRepository.findAll();
	}

	@Override
	public List<Chapter> finedCourseIdWiseRecords(long  cid) {

		
		return videoRepository.findByCourseWiseId(cid);
	}

	@Override
	public Video findTopicwiseVideo(long topicId) {
		return videoRepository.findTopicwiseVideo(topicId);
	}


}
