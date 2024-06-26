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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.AssignmentDTO;
import com.elearning.model.Assignment;
import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.model.Topic;
import com.elearning.service.AssignmentServiceInterface;
import com.elearning.service.ChapterServiceInterface;
import com.elearning.service.CourseServiceInterface;
import com.elearning.service.TopicServiceInterface;

@Controller
/*
 * @RequestMapping("/api/assignments/")
 */public class AssignmentController {

	@Autowired
	public AssignmentServiceInterface assignmentServiceInterface;

	@Autowired
	public CourseServiceInterface courseServiceInterface;

	@Autowired
	public ChapterServiceInterface chapterServiceInterface;

	@Autowired

	private TopicServiceInterface topicServiceInterface;

	@GetMapping("assignmentpage")
	public ModelAndView AssignmentPage(ModelMap map) {

		List<Course> list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);

		map.addAttribute("cId", 0);

		return new ModelAndView("addAssignments");
	}

	// view Assignments

	@GetMapping("viewAssignment")
	public ModelAndView viewAllAssignments(ModelMap map) {
		List<Course> list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);

		map.addAttribute("cId", 0);
		return new ModelAndView("viewAssignments");
	}

	@PostMapping("/viewUploadCourseId/{courseId}")
	public ModelAndView viewUploadCourse(@PathVariable("courseId") long courseId, Model map) {
		System.out.println("=============> " + courseId);
		List<Course> list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);
		List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);
		ModelAndView modelAndView = new ModelAndView("addAssignmentChapter");
		modelAndView.addObject("chapters", chapters);
		return modelAndView;
	}

	@PostMapping("UploadChaptersID/{chapterId}")
	public ModelAndView UploadChapter(@PathVariable long chapterId, Model model) {
		System.err.println("Chapter Id is :" + chapterId);
		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);

		for (Iterator<Topic> iterator = topic.iterator(); iterator.hasNext();) {
			Topic t = (Topic) iterator.next();

			System.out.println(t.getTopicName());
		}

		ModelAndView modelAndView = new ModelAndView("topicWiseAssignment");
		modelAndView.addObject("topic", topic);

		return modelAndView;

	}

	@GetMapping("uploadBulkAssignments/{topicId}")
	public ModelAndView uploadBulkAssignments(@PathVariable Integer topicId, ModelMap map) {

		System.out.println("********** Topic id is " + topicId);
		map.addAttribute("topicId", topicId);
		return new ModelAndView("uploadBulkAssignments");
	}

	@PostMapping("sendAssignment")
	public ModelAndView sendAssignments(@RequestPart("file") MultipartFile file, @RequestParam String Type,
			@RequestParam("topicId") Integer topicId, ModelMap model) {

		AssignmentDTO dto = new AssignmentDTO();
		dto.setTopicId(topicId);
		dto.setType(Type);
		String msg = assignmentServiceInterface.UploadBulkAssignments(dto, file);
 
		model.addAttribute("msg", msg);

		return new ModelAndView("uploadBulkAssignments");

	}

	// view Assignments  Information 
	
	
	@PostMapping("UploadChapterID/{chapterId}")
	public ModelAndView viewUploadChapter(@PathVariable long chapterId, Model model) {
		System.err.println("Chapter Id is :" + chapterId);
		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);


		ModelAndView modelAndView = new ModelAndView("TopicList");
		modelAndView.addObject("topic", topic);

		return modelAndView;

	}
	
	// view Bulk Assignments
	
	@GetMapping("viewBulkAssignments/{topicId}")
	  public ModelAndView viewBulkAssignments(@PathVariable long topicId)
	  {
		  System.out.println("Topic id is ++++++"+topicId);
		ModelAndView modelAndView = new ModelAndView("assignments");
		List<Assignment> assignments = assignmentServiceInterface.findByTopicWiseAssignments(topicId);
		
		  for (Iterator iterator = assignments.iterator(); iterator.hasNext();) {
			Assignment assignment = (Assignment) iterator.next();
			System.out.println(assignment.getQuestion());
			
		}
		
		modelAndView.addObject("assignments", assignments);

		return modelAndView;
	  }
	
	
}
