package com.elearning.controller;

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
import com.elearning.service.ChapterServiceInterface;
import com.elearning.service.CourseServiceInterface;
import com.elearning.service.TopicServiceInterface;
@RestController
public class TopicController {

    @Autowired
    private TopicServiceInterface topicServiceInterface;

    @Autowired
    private CourseServiceInterface courseServiceInterface;

    @Autowired
    private ChapterServiceInterface chapterServiceInterface;

    @GetMapping("topicPage")
    public ModelAndView viewTopic(ModelMap map) {
        List<Course> list = courseServiceInterface.viewCourse();
        List<Chapter> chapters = chapterServiceInterface.viewChapters();

        map.addAttribute("list", list);
        map.addAttribute("chapters", chapters);
        map.addAttribute("cId", 0);  // Default value for initial load
        return new ModelAndView("viewTopics");
    }

    @PostMapping("findByCourseId")
    public ModelAndView findByCourseIdRecords(@RequestParam("courseId") long courseId, ModelMap map) {
        System.out.println("@@@@@@@@@ " + courseId);

        List<Course> list = courseServiceInterface.viewCourse();
        List<Chapter> chapters = chapterServiceInterface.viewCourseWiseChapters(courseId);

        map.addAttribute("list", list);
        map.addAttribute("chapters", chapters);
        map.addAttribute("cId", courseId);
        return new ModelAndView("viewTopics");
    }

    @PostMapping("addTopic")
    public ModelAndView addTopic(@RequestBody TopicDTO topicDTO) {
        String msg = topicServiceInterface.addTopic(topicDTO);
        return new ModelAndView("addTopic");
    }
}
