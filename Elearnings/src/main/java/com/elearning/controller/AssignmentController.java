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

		return new ModelAndView("./assignment/addAssignments");
	}

	@PostMapping("/UploadCourseId/{courseId}")
	public ModelAndView UploadCourse(@PathVariable("courseId") long courseId, Model map) {
		List<Course> list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);
		List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);
		ModelAndView modelAndView = new ModelAndView("./assignment/addAssignmentChapter");
		modelAndView.addObject("chapters", chapters);
		return modelAndView;
	}

	@PostMapping("UploadChapterID/{chapterId}")
	public ModelAndView UploadChapter(@PathVariable long chapterId, Model model) {
		System.err.println("Chapter Id is :" + chapterId);
		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);

		for (Iterator<Topic> iterator = topic.iterator(); iterator.hasNext();) {
			Topic t = (Topic) iterator.next();

			System.err.println(t.getTopicName());
		}

		ModelAndView modelAndView = new ModelAndView("./assignment/topicWiseAssignment");
		modelAndView.addObject("topic", topic);

		return modelAndView;

	}

	@PostMapping("uploadBulkAssignments/{topicId}")
	public ModelAndView uploadBulkAssignments(@PathVariable Integer  topicId,ModelMap map ) {
		
		  System.err.println("********** Topic id is "+topicId);
		  map.addAttribute("topicId",topicId);
		return new ModelAndView("./assignment/uploadBulkAssignments");
	}

	@PostMapping("sendAssignment")
	public ModelAndView sendAssignments(@RequestPart("file") MultipartFile file, @RequestParam String Type,
			@RequestParam("topicId") Integer topicId, ModelMap model) {
		
		AssignmentDTO dto = new AssignmentDTO();
		dto.setTopicId(topicId);
		dto.setType(Type);
		String msg = assignmentServiceInterface.UploadBulkAssignments(dto, file);

		model.addAttribute("msg", msg);

		return new ModelAndView("./assignment/uploadBulkAssignments");

	}
	
	
	
	//     ******************************   view Assignments  ***********************************************
	   @GetMapping("viewAssignment")
	  public ModelAndView getAssignments(ModelMap map)
	  {
            
		   List<Course> list = courseServiceInterface.viewCourse();

			map.addAttribute("list", list);

			map.addAttribute("cId", 0);

			return new ModelAndView("./assignment/viewAssignments/viewAssignments");
	  }
	

		@PostMapping("/viewUploadCourseId/{courseId}")
		public ModelAndView viewUploadCourse(@PathVariable("courseId") long courseId, Model map) {
			List<Course> list = courseServiceInterface.viewCourse();

			  System.err.println("view CourseId "+courseId);
			
			map.addAttribute("list", list);
			List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);
			ModelAndView modelAndView = new ModelAndView("./assignment/viewAssignments/viewAssignmentChapter");
			modelAndView.addObject("chapters", chapters);
			return modelAndView;
		}
 
	   @PostMapping("viewUploadTopicID/{chapterId}")
		public ModelAndView viewUploadChapter(@PathVariable long chapterId, Model model) {
			System.err.println("Chapter Id is :" + chapterId);
			List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);

			for (Iterator<Topic> iterator = topic.iterator(); iterator.hasNext();) {
				Topic t = (Topic) iterator.next();
				System.err.println(t.getTopicName());
			}

			ModelAndView modelAndView = new ModelAndView("./assignment/viewAssignments/viewTopics");
			modelAndView.addObject("topic", topic);

			return modelAndView;

		}
	   
	    
	@PostMapping("viewUploadAssignment/{topicId}")
      public ModelAndView viewUploadTopics(@PathVariable long  topicId)
	{
		System.err.println("********* TopicId is "+topicId);
		List<Assignment> assignment = assignmentServiceInterface.findByTopicWiseAssignments(topicId);
		
		for (Iterator<Assignment> iterator = assignment.iterator(); iterator.hasNext();) {
			Assignment s = (Assignment) iterator.next();
			System.out.println(s.getQuestion());
		}
		
		ModelAndView modelAndView = new ModelAndView("./assignment/viewAssignments/assignments");
		modelAndView.addObject("assignment", assignment);

		return modelAndView;
	}
	
}
