package com.elearning.service;

import com.elearning.dto.VideoDTO;
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
    public String addVideo(VideoDTO videoDTO) {
        try {
            Integer topicId = videoDTO.getTopicId();
            Topic topic = topicRepository.findById(topicId.intValue())
                .orElseThrow(() -> new RuntimeException("Topic not found"));
            Video video = new Video(videoDTO.getTitle(), videoDTO.getDescription(), videoDTO.getUrl(), topic);
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
}
