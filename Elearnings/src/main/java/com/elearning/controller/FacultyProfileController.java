package com.elearning.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.dto.FacultyProfileDTO;
import com.elearning.model.Course;
import com.elearning.model.FacultyProfile;
import com.elearning.service.CourseServiceInterface;
import com.elearning.service.FacultyProfileServiceInterface;

@RestController
public class FacultyProfileController {

	@Autowired
	public FacultyProfileServiceInterface facultyProfileService;
	
	@Autowired
	public CourseServiceInterface courseServiceInterface;
	private static final String PROFILE_IMAGE_PATH = "D:/Projects/E-Learning/Elearnings/src/main/resources/static/uploads/";


	@GetMapping("addFacultyProfile")
	public ModelAndView viewFaculty(ModelMap map) {
		List<Course> list = courseServiceInterface.viewCourse();
		map.addAttribute("list", list);

		return new ModelAndView("./faculty/add/facultyProfile");
	}

	@PostMapping("addfaculty")
	// public ResponseEntity<String> addFaculty(@RequestBody FacultyProfileDTO
	// facultyProfileDTO)

	public ModelAndView addFaculty(@RequestParam String facultyName, @RequestPart MultipartFile profilePhoto,
			@RequestParam String designation, @RequestParam String qualification, @RequestParam String skillSet,
			@RequestParam String experience, @RequestParam long courseId) throws IOException

	{
		FacultyProfileDTO facultyProfileDTO = new FacultyProfileDTO(facultyName,profilePhoto,designation,qualification,skillSet,experience,courseId);

		   byte[] bytes = profilePhoto.getBytes();
	        File dir = new File(PROFILE_IMAGE_PATH);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        File file = new File(PROFILE_IMAGE_PATH + profilePhoto.getOriginalFilename());
	        profilePhoto.transferTo(file);

		System.out.println(facultyProfileDTO.toString());
		
		System.out.println(facultyProfileDTO.toString());

		String msg = facultyProfileService.addFaculty(facultyProfileDTO);

		return new ModelAndView("./faculty/view/facultyProfile");
	}

	// view Faculty ************************
	
	@GetMapping("viewProfile")
	public ModelAndView showFaculty(ModelMap map) {
		List<FacultyProfile> faculty = new ArrayList<FacultyProfile>();
 
		faculty = facultyProfileService.viewAllFaculty();
		
		
		 for (Iterator<FacultyProfile> iterator = faculty.iterator(); iterator.hasNext();) {
			FacultyProfile f = (FacultyProfile) iterator.next();
			System.out.println(f.getFacultyName());
		}
		
		  map.addAttribute("faculty",faculty);
		  
			return new ModelAndView("./faculty/view/viewFacultyProfile");
	}
}
