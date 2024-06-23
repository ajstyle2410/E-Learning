package com.elearning.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearning.dto.InterviewQuestionDTO;
import com.elearning.model.Chapter;
import com.elearning.model.InterviewQuestion;
import com.elearning.model.Topic;
import com.elearning.repository.ChapterRepository;
import com.elearning.repository.InterviewQuestionRepository;
import com.elearning.repository.TopicRepository;

@Service
public class InterviewQuestionService implements InterviewQuestionServiceInterface {

	@Autowired
	public InterviewQuestionRepository interviewQuestionRepository;

	@Autowired
	public TopicRepository topicRepository;
	
	@Autowired
	 public ChapterRepository chapterRepository;

	@Override
	public String addInterviewQuestion(InterviewQuestionDTO dto) {

	
		 try {
		  Topic topic =  topicRepository.findById(dto.getTopicId()).get();
		
		
		  InterviewQuestion interviewQuestion = new InterviewQuestion( dto.getQuestion(), dto.getDescription(), topic);
		  interviewQuestionRepository.save(interviewQuestion);
		  
		  return "interivew question uploaded";
		
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 return "Interview Question not uploaded...";
	}

	@Override
	public List<Chapter> finedCourseIdWiseRecords(long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

		/*
		 * @Override public String addInterviewQuestion(InterviewQuestionDTO dto) {
		 * 
		 * Set<InterviewQuestion> interveiwQuestion = parseCSV(dto, dto.getFile()); try
		 * { interviewQuestionRepository.saveAll(interveiwQuestion); } catch (Exception
		 * ex) {
		 * 
		 * } return "something error...";
		 * 
		 * }
		 * 
		 * private Set<InterviewQuestion> parseCSV(InterviewQuestionDTO dto,
		 * MultipartFile file) {
		 * 
		 * try (Reader reader = new BufferedReader(new
		 * InputStreamReader(file.getInputStream()))) {
		 * 
		 * HeaderColumnNameTranslateMappingStrategy<InterviewQuestionDTO> strategy = new
		 * HeaderColumnNameTranslateMappingStrategy<>();
		 * strategy.setType(InterviewQuestionDTO.class);
		 * 
		 * CsvToBean<InterviewQuestionDTO> csvToBean = new
		 * CsvToBeanBuilder<InterviewQuestionDTO>(reader)
		 * .withMappingStrategy(strategy).withIgnoreLeadingWhiteSpace(true).
		 * withIgnoreEmptyLine(true).build();
		 * 
		 * Topic topic = topicRepository.findById(dto.getTopicId()) .orElseThrow(() ->
		 * new IllegalArgumentException("invalid Id " + dto.getTopicId()));
		 * 
		 * @SuppressWarnings("unused") List<InterviewQuestionDTO> interviewQuestionDto =
		 * csvToBean.parse(); Set<InterviewQuestion> interviewQuestions = new
		 * HashSet<>();
		 * 
		 * for (InterviewQuestion iq : interviewQuestions) {
		 * 
		 * InterviewQuestion questions =
		 * InterviewQuestion.builder().question(iq.getQuestion())
		 * .description(iq.getDescription()).topic(topic).build();
		 * interviewQuestions.add(questions); }
		 * 
		 * return interviewQuestions;
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * return Collections.emptySet(); }
		 * 
		 * @Override public List<Chapter> finedCourseIdWiseRecords(long courseId) {
		 * 
		 * 
		 * return chapterRepository.findByCourseWiseId(courseId); }
		 */
}
