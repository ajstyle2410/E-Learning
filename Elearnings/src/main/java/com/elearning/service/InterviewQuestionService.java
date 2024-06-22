//package com.elearning.service;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.elearning.dto.ChapterDTO;
//import com.elearning.dto.InterviewQuestionDTO;
//import com.elearning.model.Chapter;
//import com.elearning.model.InterviewQuestion;
//import com.elearning.model.Topic;
//import com.elearning.repository.ChapterRepository;
//import com.elearning.repository.InterviewQuestionRepository;
//import com.elearning.repository.TopicRepository;
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;
//import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
//
//@Service
//public class InterviewQuestionService implements InterviewQuestionServiceInterface {
//
//	@Autowired
//	public InterviewQuestionRepository interviewQuestionRepository;
//
//	@Autowired
//	public TopicRepository topicRepository;
//
//	@Override
//	public String addInterviewQuestion(InterviewQuestionDTO dto) {
//
//		Set<InterviewQuestion> interveiwQuestion = parseCSV(dto, dto.getFile());
//		try {
//			interviewQuestionRepository.saveAll(interveiwQuestion);
//		} catch (Exception ex) {
//
//		}
//		return "something error...";
//
//	}
//
//	private Set<InterviewQuestion> parseCSV(InterviewQuestionDTO dto, MultipartFile file) {
//
//		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//
//			HeaderColumnNameTranslateMappingStrategy<InterviewQuestionDTO> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
//			strategy.setType(InterviewQuestionDTO.class);
//
//			CsvToBean<InterviewQuestionDTO> csvToBean = new CsvToBeanBuilder<InterviewQuestionDTO>(reader)
//					.withMappingStrategy(strategy).withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true).build();
//
//			Topic topic = topicRepository.findById(dto.getTopicId())
//					.orElseThrow(() -> new IllegalArgumentException("invalid Id " + dto.getTopicId()));
//
//			List<InterviewQuestionDTO> interviewQuestionDto = csvToBean.parse();
//			Set<InterviewQuestion> interviewQuestions = new HashSet<>();
//
//			for (InterviewQuestion iq : interviewQuestions) {
//
//				InterviewQuestion questions = InterviewQuestion.builder().question(iq.getQuestion())
//						.description(iq.getDescription()).topic(topic).build();
//				interviewQuestions.add(questions);
//			}
//
//			return interviewQuestions;
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		return Collections.emptySet();
//	}
//
//}
