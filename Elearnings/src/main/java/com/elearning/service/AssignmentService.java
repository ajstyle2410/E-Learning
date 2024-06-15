package com.elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.AssignmentDTO;
import com.elearning.model.Assignment;
import com.elearning.model.Topic;
import com.elearning.repository.AssignmentRepository;
import com.elearning.repository.TopicRepository;

@Service
public class AssignmentService implements AssignmentServiceInterface {

	@Autowired
	public AssignmentRepository assignmentRepo;
	
	@Autowired
    private TopicRepository topicRepository;

	@Override
	public String addAssignments(AssignmentDTO assignmentDTO) {

        Integer topicId = assignmentDTO.getTopicId();
        Topic topic = topicRepository.findById(topicId.intValue()).get();
		
		
		Assignment assignment = new Assignment(assignmentDTO.getQuestion(), assignmentDTO.getDescription(),
				assignmentDTO.getType(),topic );

		try {
			assignmentRepo.save(assignment);
			
			return assignment.getQuestion();
		} catch (Exception ex) {
			System.out.println("Assignment error is " + ex);
		}
		return "No";
	}

}
