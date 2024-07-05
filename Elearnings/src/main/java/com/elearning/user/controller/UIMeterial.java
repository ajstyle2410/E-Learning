package com.elearning.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UIMeterial {

	@GetMapping("uiMeterial")
	public ModelAndView uiMeterial() {
		return new ModelAndView("./user/UI_Meterial/UIMeterial");
	}
}
