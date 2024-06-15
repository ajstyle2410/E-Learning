package com.elearning.service;

import java.util.List;

import com.elearning.dto.VideoDTO;
import com.elearning.model.Video;

public interface VideoServiceInterface {

	public String addVideo(VideoDTO video);

	public List<Video> getVideos();

}
