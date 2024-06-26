package com.elearning.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.elearning.dto.AssignmentDTO;
import com.elearning.model.Assignment;

public interface AssignmentServiceInterface {

	public String addAssignments(AssignmentDTO assignmentDTO);

	public String UploadBulkAssignments(AssignmentDTO dto, MultipartFile file);

	public List<Assignment> findByTopicWiseAssignments(long topicId);

}
