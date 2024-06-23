package com.elearning.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.InterviewQuestionDTO;
import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.model.InterviewQuestion;
import com.elearning.model.Topic;
import com.elearning.service.ChapterServiceInterface;
import com.elearning.service.CourseServiceInterface;
import com.elearning.service.InterviewQuestionServiceInterface;
import com.elearning.service.TopicServiceInterface;

@RestController
public class InterviewController {

	@Autowired
	public InterviewQuestionServiceInterface interviewQuestionInterface;

	@Autowired
	private ChapterServiceInterface chapterServiceInterface;

	@Autowired
	private CourseServiceInterface courseServiceInterface;

	@Autowired

	private TopicServiceInterface topicServiceInterface;

	@GetMapping("addInterviewQustion")
	public ModelAndView viewInterviewQuestion(ModelMap map) {

		List<Course> lists = courseServiceInterface.viewCourse();

		map.addAttribute("lists", lists);
		map.addAttribute("cId", 0);

		return new ModelAndView("addInterviewQuestion");
	}

	@GetMapping("/uploadCourseIds/{courseId}")
	public ModelAndView uploadCourseId(@PathVariable long courseId, ModelMap map) {

		List<Chapter> chapter = interviewQuestionInterface.finedCourseIdWiseRecords(courseId);
		map.addAttribute("list", chapter);

		List<Course> lists = courseServiceInterface.viewCourse();
		map.addAttribute("lists", lists);
		return new ModelAndView("addInterviewQuestion");
	}

	@GetMapping("uplodChapterIds/{chapterId}")
	public ModelAndView uploadChapterWiseTopicQuestion(@PathVariable long chapterId, ModelMap model) {

		System.out.println("*************** chapter id is " + chapterId);

		List<Course> lists = courseServiceInterface.viewCourse();
		model.addAttribute("lists", lists);
		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);

		model.addAttribute("topic", topic);

		return new ModelAndView("addInterviewQuestion");

	}

	@GetMapping("/uploadQuestionTopic/{topicId}")
	public ModelAndView AddInterviewQuestion(@PathVariable long topicId, ModelMap map) {

		System.out.println("topic id is " + topicId);

		map.addAttribute("topicId", topicId);

		return new ModelAndView("uploadInterviewQuestion");
	}
	
	
	@PostMapping("uploadedQuestion")
	   public ModelAndView  getUploadQuestion(@RequestParam String question, @RequestParam String description, @RequestParam Integer  topicId)
	    
  //  public ModelAndView  getUploadQuestion(@RequestBody InterviewQuestionDTO dto)

	{
		
		  InterviewQuestionDTO dto = new InterviewQuestionDTO(description, description, topicId);
		  
		  interviewQuestionInterface.addInterviewQuestion(dto);
		  
			return new ModelAndView("uploadInterviewQuestion");
		
	    }
	

	
	
	/*
	 * 
	 * @GetMapping("/uploadCourseIds/{courseId}") public ModelAndView
	 * uploadCourseId(@PathVariable long courseId, ModelMap map) {
	 * System.out.println(courseId);
	 * 
	 * List<Chapter> chapter =
	 * interviewQuestionInterface.finedCourseIdWiseRecords(courseId);
	 * map.addAttribute("list", chapter);
	 * 
	 * 
	 * for (Iterator iterator = chapter.iterator(); iterator.hasNext();) { Chapter c
	 * = (Chapter) iterator.next();
	 * 
	 * System.out.println(c.toString());
	 * 
	 * }
	 * 
	 * List<Course> lists = courseServiceInterface.viewCourse();
	 * map.addAttribute("lists", lists);
	 * 
	 * return new ModelAndView("addInterviewQuestion"); }
	 * 
	 * 
	 * @GetMapping("/uploadCourseIds/{courseId}") public ModelAndView
	 * uploadCourseId(@PathVariable long courseId, ModelMap map) {
	 * System.out.println(courseId);
	 * 
	 * List<Chapter> chapter =
	 * interviewQuestionInterface.finedCourseIdWiseRecords(courseId);
	 * map.addAttribute("list", chapter);
	 * 
	 * List<Course> lists = courseServiceInterface.viewCourse();
	 * map.addAttribute("lists", lists);
	 * 
	 * return new ModelAndView("addInterviewQuestion"); }
	 * 
	 * @PostMapping("uploadInterviewQuestion") public ModelAndView
	 * uploadInterviewQuestions(@RequestPart("file") MultipartFile file,
	 * 
	 * @RequestParam("Description") String Description, @RequestParam("Question")
	 * String Question,
	 * 
	 * @RequestParam Integer topicId) {
	 * 
	 * 
	 * InterviewQuestionDTO dto = new InterviewQuestionDTO(Question, file, Question,
	 * topicId);
	 * 
	 * String msg = interviewQuestionInterface.addInterviewQuestion(dto);
	 * 
	 * System.out.println(msg); return new
	 * ModelAndView("redirect:addInterviewQuestion"); }
	 * 
	 * @PostMapping("uploadInterviewQuestions") public ModelAndView
	 * uploadChpaterWiseInterviewQuestion(@RequestParam MultipartFile
	 * file, @RequestParam long chapterId) {
	 * 
	 * System.out.println(file.getOriginalFilename() + "\t" + chapterId);
	 * 
	 * return new ModelAndView("addInterviewQuestion");
	 * 
	 * }
	 */
}
