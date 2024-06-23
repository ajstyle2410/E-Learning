package com.elearning.service;

import java.util.List;


import com.elearning.model.Chapter;
import com.elearning.model.Video;

public interface VideoServiceInterface {

	public String addVideo(Video video);

	public List<Video> getVideos();

	public List<Chapter> finedCourseIdWiseRecords(long cid);

	public Video findTopicwiseVideo(long topicId);
}
