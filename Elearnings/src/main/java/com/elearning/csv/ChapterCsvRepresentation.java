package com.elearning.csv;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChapterCsvRepresentation {
	@CsvBindByName(column="chapterName")
	private String ChapterName;
	@CsvBindByName(column="courseId")
	private int  courseId;
}
