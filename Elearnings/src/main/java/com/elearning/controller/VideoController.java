package com.elearning.controller;

import com.elearning.model.Chapter;
import com.elearning.model.Course;
import com.elearning.model.Topic;
import com.elearning.model.Video;
import com.elearning.service.CourseServiceInterface;
import com.elearning.service.TopicServiceInterface;
import com.elearning.service.VideoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class VideoController {

	@Autowired
	private VideoServiceInterface videoService;

	@Autowired
	private TopicServiceInterface topicServiceInterface;

	@Autowired
	private CourseServiceInterface courseServiceInterface;

	@GetMapping("viewVideo")
	public ModelAndView getAllVideos(ModelMap map) {
		List<Course> list = courseServiceInterface.viewCourse();
		List<Chapter> chapter = new ArrayList<>();
		List<Video> v = new ArrayList<>();
		map.addAttribute("video", v);
		map.addAttribute("list", list);
		map.addAttribute("chapter", chapter);
		return new ModelAndView("TopicVideo");
	}

	@GetMapping("CourseId/{cid}")
	public ModelAndView getCourseId(@PathVariable long cid, ModelMap map) {
		map.addAttribute("cid", cid);
		List<Chapter> chapter = videoService.finedCourseIdWiseRecords(cid);
		List<Course> list = courseServiceInterface.viewCourse();
		List<Video> v = new ArrayList<>();
		map.addAttribute("video", v);
		map.addAttribute("list", list);
		map.addAttribute("chapter", chapter);
		return new ModelAndView("TopicVideo");
	}

	@PostMapping("viewchapterwisetopic")
	public ModelAndView ViewTopicByChapterName(ModelMap map, @RequestParam("chapterId") long chapterId) {

		List<Chapter> chapter = videoService.finedCourseIdWiseRecords(chapterId);
		List<Course> list = courseServiceInterface.viewCourse();
		List<Topic> topic = topicServiceInterface.viewChapterWiseSTopics(chapterId);

		List<Video> v = new ArrayList<>();

		for (Iterator<Topic> iterator = topic.iterator(); iterator.hasNext();) {
			Topic t = (Topic) iterator.next();

			Video videos = videoService.findTopicwiseVideo(t.getTopicId());
			v.add(videos);
		}

		for (Iterator<Video> iterator = v.iterator(); iterator.hasNext();) {
			Video video = (Video) iterator.next();

		}
		map.addAttribute("list", list);
		map.addAttribute("chapter", chapter);
		map.addAttribute("cid", chapterId);
		map.addAttribute("video", v);
		return new ModelAndView("TopicVideo");
	}
}
