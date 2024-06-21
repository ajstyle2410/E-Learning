package com.elearning.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	        List<Chapter> chapters = chapterServiceInterface.viewChapters();

	        map.addAttribute("list", list);
	        map.addAttribute("chapters", chapters);
	        map.addAttribute("cId", 0);  // Default value for initial load
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

		list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);

		return new ModelAndView("viewChapter");
	}
	

	@PostMapping("viewChapters")
	public ModelAndView viewCourseWiseChapters(ModelMap map, @RequestParam("courseId") Integer  courseId) {
		  System.out.println("@@@@@@@@@ " + courseId);

	        List<Course> list = courseServiceInterface.viewCourse();
	        List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);

	        map.addAttribute("list", list);
	        map.addAttribute("chapters", chapters);
	        map.addAttribute("cId", courseId);

		return new ModelAndView("viewChapter");
	}

}
