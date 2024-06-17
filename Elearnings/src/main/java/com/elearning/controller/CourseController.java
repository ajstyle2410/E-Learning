package com.elearning.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.CourseDTO;
import com.elearning.model.Course;
import com.elearning.service.CourseServiceInterface;

@RestController
//@RequestMapping("/api/courses/")
public class CourseController {

	private static final String COURSE_IMAGE_PATH = "D:/Projects/E-Learning/Elearnings/src/main/resources/images/course/banner/";

	@Autowired
	private CourseServiceInterface courseServiceInterface;

	@PostMapping("addcourses")
	public ModelAndView addCourse(@RequestParam("courseName") String courseName, @RequestParam("fees") int fees,
			@RequestParam("noOfHours") int noOfHours, @RequestParam("prerequisites") String prerequisites,
			@RequestParam("banner") MultipartFile banner, @RequestParam("type") String type,
			@RequestParam("objective") String objective) throws IOException {
		// Save the file to the local filesystem
		byte[] bytes = banner.getBytes();
		File dir = new File(COURSE_IMAGE_PATH);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(COURSE_IMAGE_PATH + banner.getOriginalFilename());
		banner.transferTo(file);

		// Convert DTO to entity
		CourseDTO course = new CourseDTO();
		course.setCourseName(courseName);
		course.setFees(fees);
		course.setNoOfHours(noOfHours);
		course.setPrerequisites(prerequisites);
		course.setPath(file.getAbsolutePath());
		course.setType(type);
		course.setObjective(objective);
		course.setBanner(banner);

  System.out.println(course.toString());
  courseServiceInterface.addCourse(course);
		return new ModelAndView("redirect:courselist");
	}

	@GetMapping("courselist")
	public ModelAndView viewCourse(Model map) {
		List<Course>  list = courseServiceInterface.viewCourse();
		
		 for (Iterator<Course> iterator = list.iterator(); iterator.hasNext();) {
			Course c = (Course) iterator.next();
			System.out.println(c.toString());
			
		}
		
		map.addAttribute("list", list);
		
		return new ModelAndView("viewCourse");
	}
}
