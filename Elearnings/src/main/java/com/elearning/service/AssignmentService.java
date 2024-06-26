package com.elearning.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elearning.dto.AssignmentDTO;
import com.elearning.model.Assignment;
import com.elearning.model.Topic;
import com.elearning.repository.AssignmentRepository;
import com.elearning.repository.TopicRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

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
				assignmentDTO.getType(), topic);

		try {
			assignmentRepo.save(assignment);

			return assignment.getQuestion();
		} catch (Exception ex) {
			System.out.println("Assignment error is " + ex);
		}
		return "No";
	}

    @Override
    public String UploadBulkAssignments(AssignmentDTO dto, MultipartFile file) {
        Set<Assignment> assignments = parseCSV(dto, file);
        assignmentRepo.saveAll(assignments);
        return "Assignments Uploaded Successfully";
    }

    private Set<Assignment> parseCSV(AssignmentDTO dto, MultipartFile file) {
        Set<Assignment> assignments = new HashSet<>();
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<AssignmentDTO> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(AssignmentDTO.class);
            CsvToBean<AssignmentDTO> csvToBean = new CsvToBeanBuilder<AssignmentDTO>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            List<AssignmentDTO> assignmentDTOs = csvToBean.parse();
            for (AssignmentDTO assignmentDTO : assignmentDTOs) {
                Assignment assignment = Assignment.builder()
                        .Question(assignmentDTO.getQuestion())
                        .Description(assignmentDTO.getDescription())
                        .Type(dto.getType())
                        .topic(topicRepository.findById(dto.getTopicId())
                                .orElseThrow(() -> new IllegalArgumentException("Invalid topic ID: " + dto.getTopicId())))
                        .build();
                assignments.add(assignment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptySet();
        }
        return assignments;
    }

	@Override
	public List<Assignment> findByTopicWiseAssignments(long topicId) {
		return assignmentRepo.findByTopicWiseAssignments(topicId);
	}
}
