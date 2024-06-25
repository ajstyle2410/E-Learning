package com.elearning.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.AssignmentDTO;
import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.service.AssignmentServiceInterface;
import com.elearning.service.ChapterServiceInterface;
import com.elearning.service.CourseServiceInterface;

@Controller
/*
 * @RequestMapping("/api/assignments/")
 */public class AssignmentController {

	/*
	 * @Autowired public AssignmentServiceInterface assignmentServiceInterface;
	 * 
	 * 
	 */
	
	@Autowired
    public CourseServiceInterface 	courseServiceInterface;
	
	@Autowired
	 public ChapterServiceInterface  chapterServiceInterface;

	
	@GetMapping("assignmentpage")
	 public ModelAndView  AssignmentPage(ModelMap map)
	 {
		
		 List<Course> list = courseServiceInterface.viewCourse();

	        map.addAttribute("list", list);
	        
	        map.addAttribute("cId", 0); 
		
		 return new ModelAndView("addAssignments");
	 }
	

	@PostMapping("/viewUploadCourseId/{courseId}")
	public ModelAndView viewUploadCourse(@PathVariable("courseId") long courseId,Model map) {
	    System.out.println("=============> "+courseId);
	    List<Course> list = courseServiceInterface.viewCourse();

        map.addAttribute("list", list);
	    List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);
	    ModelAndView modelAndView = new ModelAndView("addAssignmentChapter");
	    modelAndView.addObject("chapters", chapters);
	    modelAndView.addObject("cid",courseId);
	    return modelAndView;
	}

}
