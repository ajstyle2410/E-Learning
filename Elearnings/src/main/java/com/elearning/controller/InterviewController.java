//package com.elearning.controller;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.elearning.dto.InterviewQuestionDTO;
//import com.elearning.model.Chapter;
//import com.elearning.model.InterviewQuestion;
//import com.elearning.service.ChapterServiceInterface;
//import com.elearning.service.InterviewQuestionServiceInterface;
//
//@RestController
//public class InterviewController {
//
//	@Autowired
//	public InterviewQuestionServiceInterface interviewQuestionInterface;
//	
//	@Autowired
//	  private ChapterServiceInterface chapterServiceInterface;
//
//	@GetMapping("addInterviewQustion")
//	public ModelAndView viewInterviewQuestion(ModelMap map ) {
//
//		List<Chapter> list =  chapterServiceInterface.viewChapters();
//		map.addAttribute("list",list);
//		   
//		return new ModelAndView("addInterviewQuestion");
//	}
//
//	@PostMapping("uploadInterviewQuestion")
//	public ModelAndView uploadInterviewQuestions(@RequestPart("file") MultipartFile file,
//			@RequestParam("Description") String Description, @RequestParam("Question") String Question,
//			@RequestParam Integer topicId) {
//		
//		  InterviewQuestionDTO dto = new InterviewQuestionDTO(Question, file, Question, topicId);
//		
//		String msg = interviewQuestionInterface.addInterviewQuestion(dto);
//
//		System.out.println(msg);
//		return new ModelAndView("redirect:addInterviewQuestion");
//	}
//}
