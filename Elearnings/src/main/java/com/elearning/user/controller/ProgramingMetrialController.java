package com.elearning.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.model.Course;
import com.elearning.service.CourseServiceInterface;

@RestController
public class ProgramingMetrialController {

	@Autowired
	private CourseServiceInterface courseServieInterface;

	@GetMapping("programingMeterial")
	public ModelAndView programingMeterial(ModelMap map) {

		List<Course> course = courseServieInterface.viewCourse();

        map.addAttribute("course",course);
		         
		return new ModelAndView("./user/ProgramingMeterial/ProgramingMetrial");
	}
}