package com.elearning.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.service.ChapterServiceInterface;
import com.elearning.service.CourseServiceInterface;

@RestController
public class ChapterController {

	@Autowired
	private ChapterServiceInterface chapterServiceInterface;

	@Autowired
	private CourseServiceInterface courseServiceInterface;

	@GetMapping("addChapters")
	public ModelAndView addChapter(Model map) {

		List<Course> list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);
		return new ModelAndView("addChapter");
	}

	@PostMapping("/uploadchapter")
	public ModelAndView viewChapter(@RequestPart("file") MultipartFile file,
			@RequestParam("courseId") String courseId) {

		String msg = chapterServiceInterface.addChpaters(file, Long.parseLong(courseId));
		System.out.println(msg);
		return new ModelAndView("addChapter");

	}

	@GetMapping("viewByIdChapter")

	public ModelAndView viewIdByChapter(ModelMap map) {
		List<Course> list = new ArrayList<Course>();

		System.err.println("@@@@@@@@@@@@@@");
		
		list = courseServiceInterface.viewCourse();
		
		System.out.println("#####################"+list);
		
		 for (Iterator<Course> iterator = list.iterator(); iterator.hasNext();) {
			Course course = (Course) iterator.next();
			
			System.err.println(course.getCourseName());
		}

		map.addAttribute("list", list);

		return new ModelAndView("viewChapter");
	}

	@PostMapping("viewChapters")
	public ModelAndView viewCourseWiseChapters(ModelMap map, @RequestParam("courseId") long courseId) {

		List<Chapter> list = chapterServiceInterface.viewCourseWiseChapters(courseId);

		for (Iterator<Chapter> iterator = list.iterator(); iterator.hasNext();) {
			Chapter chapter = (Chapter) iterator.next();
			System.err.println(chapter.getCourse().getCourseId());
		}

		map.addAttribute("list", list);
		
		return new ModelAndView("redirect:viewByIdChapter");

	}

}
