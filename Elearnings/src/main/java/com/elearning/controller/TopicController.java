package com.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.TopicDTO;
import com.elearning.service.TopicServiceInterface;

@RestController
public class TopicController {

	@Autowired
	public TopicServiceInterface topicServiceInterface;

	@PostMapping("addTopic")
	public ResponseEntity<String> addTopic(@RequestBody TopicDTO topicDTO) {
		String msg = topicServiceInterface.addTopic(topicDTO);
		return new ResponseEntity<String>(msg+ " Topic Added....", HttpStatus.ACCEPTED);

	}
}
