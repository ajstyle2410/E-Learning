package com.elearning.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.elearning.model.Chapter;

public interface ChapterServiceInterface {

	public String  addChpaters(MultipartFile file, long  courseId);


	public List<Chapter> viewCourseWiseChapters(long courseId);


	public List<Chapter> viewChapters();
	

}
