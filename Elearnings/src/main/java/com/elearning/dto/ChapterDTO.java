package com.elearning.dto;

import com.opencsv.bean.CsvBindByName;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChapterDTO {
	private String ChapterName;
	private int  courseId;

	public ChapterDTO(String chapterName, int course) {
		super();
		ChapterName = chapterName;
		this.courseId = course;
	}
	   
	
}