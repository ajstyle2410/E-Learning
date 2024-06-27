package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.InterviewQuestionDTO;
import com.elearning.model.Chapter;
import com.elearning.model.Course;
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
	private CourseServiceInterface courseServiceInterface;

	@Autowired

	private TopicServiceInterface topicServiceInterface;

	@Autowired
	private ChapterServiceInterface chapterServiceInterface;

	@GetMapping("addInterviewQustion")
	public ModelAndView viewInterviewQuestion(ModelMap map) {

		List<Course> lists = courseServiceInterface.viewCourse();

		map.addAttribute("lists", lists);
		map.addAttribute("cId", 0);

		return new ModelAndView("./interview/add/addInterviewQuestion");
	}

	@PostMapping("/uploadCourseId/{courseId}")
	public ModelAndView uploadCourseId(@PathVariable long courseId, ModelMap map) {
		System.err.println("Course Id" + courseId);

		List<Chapter> chapter = interviewQuestionInterface.finedCourseIdWiseRecords(courseId);
		map.addAttribute("list", chapter);

		return new ModelAndView("./interview/add/Chapter");
	}

	// view Chpaters for ViewInterview Question

	@PostMapping("/UploadChapterId/{chapterId}")
	public ModelAndView uploadCoursesId(@PathVariable long chapterId, ModelMap map) {

		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);

		map.addAttribute("topic", topic);

		return new ModelAndView("./interview/add/InterivewTopicList");
	}

	@PostMapping("UploadTopicId/{TopicId}")
	public ModelAndView uplodeTopicId(@PathVariable long TopicId, ModelMap map) {

		System.err.println("===> " + TopicId);

		map.addAttribute("TopicId", TopicId);

		return new ModelAndView("./interview/add/uploadInterviewQuestion");

	}

	@PostMapping("uploadedQuestion")
	public ModelAndView uploadedQuestion(@ModelAttribute InterviewQuestionDTO dto, Model model) {

		interviewQuestionInterface.addInterviewQuestion(dto);
		System.out.println(dto.toString());

		// return new ModelAndView("redirect:/redirectedUrl");
		return new ModelAndView("./interview/add/addInterviewQuestion");

	}

	@GetMapping("viewInterviewQuestion")
	public ModelAndView viewInterivewQuestion(ModelMap map) {
		List<Course> lists = courseServiceInterface.viewCourse();

		map.addAttribute("lists", lists);
		return new ModelAndView("./interview/view/viewInterviewQuestion");
	}

	@PostMapping("sendUploadCourseId/{courseId}")
	public ModelAndView viewUploadCourseId(@PathVariable long courseId, ModelMap map) {

		List<Chapter> chapter = chapterServiceInterface.viewCourseWiseChapters(courseId);

		 map.addAttribute("chapter" , chapter);
		 
		return new ModelAndView("./interview/view/Chapter");

	}

	// view Chpater wise topics

	/*
	 * 
	 * 
	 * @GetMapping("viewUplodChapterIds/{chapterId}") public ModelAndView
	 * uploadChapterWiseTopicQuestions(@PathVariable long chapterId, ModelMap model)
	 * {
	 * 
	 * 
	 * System.out.println("Chapter id is ======>"+chapterId);
	 * 
	 * 
	 * List<Course> lists = courseServiceInterface.viewCourse();
	 * model.addAttribute("lists", lists); List<Topic> topic =
	 * topicServiceInterface.viewChapterWiseSTopics(chapterId);
	 * 
	 * for (Iterator<Topic> iterator = topic.iterator(); iterator.hasNext();) {
	 * Topic t = (Topic) iterator.next();
	 * 
	 * System.err.println("****************************"+t.getTopicName()); }
	 * 
	 * model.addAttribute("topic", topic); return new
	 * ModelAndView("viewInterviewQuestion");
	 * 
	 * }
	 * 
	 */
	/*
	 * @GetMapping("uplodChapterIds/{chapterId}") public ModelAndView
	 * uploadChapterWiseTopicQuestion(@PathVariable long chapterId, ModelMap model)
	 * {
	 * 
	 * System.out.println("*************** chapter id is " + chapterId);
	 * 
	 * List<Course> lists = courseServiceInterface.viewCourse();
	 * model.addAttribute("lists", lists); List<Topic> topic =
	 * topicServiceInterface.viewChapterWiseSTopics(chapterId);
	 * 
	 * model.addAttribute("topic", topic);
	 * 
	 * return new ModelAndView("addInterviewQuestion");
	 * 
	 * }
	 * 
	 * // getViewChapter Id
	 * 
	 * @GetMapping("viewChapterIds/{chapterId}") public ModelAndView
	 * viewChapterWiseTopicQuestion(@PathVariable long chapterId, ModelMap model) {
	 * 
	 * System.out.println("***************> chapter id is " + chapterId);
	 * 
	 * List<Course> lists = courseServiceInterface.viewCourse();
	 * model.addAttribute("lists", lists); List<Topic> topic =
	 * topicServiceInterface.viewChapterWiseSTopics(chapterId);
	 * 
	 * model.addAttribute("topic", topic);
	 * 
	 * return new ModelAndView("viewInterviewQuestion");
	 * 
	 * }
	 * 
	 * @GetMapping("/uploadQuestionTopic/{topicId}") public ModelAndView
	 * AddInterviewQuestion(@PathVariable long topicId, ModelMap map) {
	 * 
	 * System.out.println("topic id is " + topicId);
	 * 
	 * map.addAttribute("topicId", topicId);
	 * 
	 * return new ModelAndView("uploadInterviewQuestion"); }
	 * 
	 * // // viewInteriveQuestions //
	 * // @GetMapping("/uploadQuestionTopics/{topicId}") // public ModelAndView
	 * viewInterviewQuestions(@PathVariable long topicId, ModelMap map) { // //
	 * System.out.println("topic id is " + topicId); // // List<InterviewQuestion>
	 * interviewQuestion =
	 * interviewQuestionInterface.viewInterviewQuestionByTopicId(topicId); // //
	 * map.addAttribute("topicId", topicId); // // return new
	 * ModelAndView("viewInterviewQuestion"); // }
	 * 
	 * // view by Topic Id wise
	 * 
	 * @GetMapping("/viewInterviewQuestionByTopicId/{topicId}") public ModelAndView
	 * viewInterviewQuestionByTopicId(@PathVariable("topicId") long topicId,
	 * ModelMap map) {
	 * 
	 * System.out.println("======> Topic Id is :" + topicId);
	 * List<InterviewQuestion> interviewQuestion =
	 * interviewQuestionInterface.viewInterviewQuestionByTopicId(topicId);
	 * 
	 * map.addAttribute("InterviewQuestion", interviewQuestion);
	 * 
	 * return new ModelAndView("viewInterviewQuestion");
	 * 
	 * }
	 * 
	 * @PostMapping("uploadedQuestion") public ModelAndView
	 * getUploadQuestion(@RequestParam String question, @RequestParam String
	 * description,
	 * 
	 * @RequestParam Integer topicId)
	 * 
	 * // public ModelAndView getUploadQuestion(@RequestBody InterviewQuestionDTO
	 * dto)
	 * 
	 * {
	 * 
	 * InterviewQuestionDTO dto = new InterviewQuestionDTO(description, description,
	 * topicId);
	 * 
	 * interviewQuestionInterface.addInterviewQuestion(dto);
	 * 
	 * return new ModelAndView("uploadInterviewQuestion");
	 * 
	 * }
	 * 
	 * /*
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
