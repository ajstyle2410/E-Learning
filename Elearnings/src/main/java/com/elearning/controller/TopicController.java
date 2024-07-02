package com.elearning.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.TopicDTO;
import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.model.Topic;
import com.elearning.model.Video;
import com.elearning.service.ChapterServiceInterface;
import com.elearning.service.CourseServiceInterface;
import com.elearning.service.TopicServiceInterface;
import com.elearning.service.VideoServiceInterface;

@RestController
public class TopicController {

	@Autowired
	private TopicServiceInterface topicServiceInterface;

	@Autowired
	private CourseServiceInterface courseServiceInterface;

	@Autowired
	private ChapterServiceInterface chapterServiceInterface;

	@Autowired
	private VideoServiceInterface videoServiceInterface;

	@GetMapping("topicPage")
	public ModelAndView viewTopic(ModelMap map) {
		List<Course> list = courseServiceInterface.viewCourse();
		// List<Chapter> chapters = chapterServiceInterface.viewChapters();

		map.addAttribute("list", list);
		return new ModelAndView("./topic/add/AddTopicCourse");
	}

	@PostMapping("uploadCourseByTopic/{courseId}")
	public ModelAndView findByCourseIdRecords(@PathVariable long courseId, ModelMap map) {
		System.err.println("Course Id " + courseId);

		List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);

		map.addAttribute("chapters", chapters);

		return new ModelAndView("./topic/add/addTopicChapter");
	}

	@PostMapping("addTopics/{chapterId}")
	public ModelAndView addTopics(@PathVariable Integer chapterId, ModelMap map) {
		map.addAttribute("cid", chapterId);
		return new ModelAndView("./topic/view/viewTopics");
	}

	@PostMapping("uploadChpaerByTopic/{chapterId}")
	public ModelAndView adduploadChpaerByTopic(@PathVariable long chapterId, ModelMap map) {
		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);
		map.addAttribute("topic", topic);
		map.addAttribute("chapterId", chapterId);
		return new ModelAndView("./topic/add/addTopic");

	}

	@PostMapping("addTopicss")
	public ModelAndView saveTopic(@RequestParam("topicName") String topicName, @RequestParam String topicTitle,

			@RequestParam String topicDescription, @RequestParam String videoUrl, @RequestParam Integer chapterId) {
		TopicDTO topic = new TopicDTO(topicName, chapterId);
		topicServiceInterface.addTopics(topic);
		Topic topics = topicServiceInterface.findByTopicRecords(topicName);
		Video video = new Video(topicDescription, topicTitle, videoUrl, topics);
		String msg = videoServiceInterface.addVideo(video);

		System.out.println(msg);
		return new ModelAndView("redirect:/topicPage");

	}

	// ***************** View Topics ************************************

	@GetMapping("viewTopicPage")

	public ModelAndView viewTopicPage(ModelMap map) {

		List<Course> list = courseServiceInterface.viewCourse();

		map.addAttribute("list", list);

		return new ModelAndView("./topic/view/viewTopicPage");
	}

	@PostMapping("CourseId/{courseId}")
	public ModelAndView getCourseId(@PathVariable long courseId, ModelMap map) {
		System.err.println("*** =========> " + courseId);
		List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);

		map.addAttribute("chapters", chapters);
		return new ModelAndView("./topic/view/viewTopicChapter");
	}

	@PostMapping("TopicChapterId/{chapterId}")
	public ModelAndView getTopicChapterId(@PathVariable long chapterId,ModelMap map) {

		
	List<Topic>  topic=	topicServiceInterface.viewChapterWiseSTopics(chapterId);
	
	  map.addAttribute("topic",topic);
		return new ModelAndView("./topic/view/viewTopic");

	}

}
