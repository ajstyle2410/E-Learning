package com.elearning.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elearning.csv.ChapterCsvRepresentation;
import com.elearning.dto.ChapterDTO;
import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.repository.ChapterRepository;
import com.elearning.repository.CourseRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

@Service
public class ChapterService implements ChapterServiceInterface {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ChapterRepository chapterRepository;

	@Override
	public String addChpaters(MultipartFile file, long courseId) {

		Set<Chapter> chapters = parseCSV(file, courseId);

		if (!chapters.isEmpty()) {
			chapterRepository.saveAll(chapters);
			return "Chapters added successfully";
		}
		return "No chapters were added";
	}

	private Set<Chapter> parseCSV(MultipartFile file, long courseId) {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			HeaderColumnNameMappingStrategy<ChapterDTO> strategy = new HeaderColumnNameMappingStrategy<>();
			strategy.setType(ChapterDTO.class);
			CsvToBean<ChapterDTO> csvToBean = new CsvToBeanBuilder<ChapterDTO>(reader).withMappingStrategy(strategy)
					.withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true).build();

			Course course = courseRepository.findById(courseId)
					.orElseThrow(() -> new IllegalArgumentException("Invalid course ID: " + courseId));

			List<ChapterDTO> chapterDTOs = csvToBean.parse();
			Set<Chapter> chapters = new HashSet<>();

			for (ChapterDTO data : chapterDTOs) {
				Chapter chapter = Chapter.builder().ChapterName(data.getChapterName()).course(course).build();
				chapters.add(chapter);
			}
			return chapters;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptySet();
		}
	}



	@Override
	public List<Chapter> viewChapters() {
		
		         
		
		return  chapterRepository.findAll();
	}

	@Override
	public List<Chapter> viewCourseWiseChapters(long courseId) {
		return chapterRepository.findByCourseWiseId(courseId);
	}

}
