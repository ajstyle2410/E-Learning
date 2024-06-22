package com.elearning.model;

import java.util.Set;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private long topicId;

    private String topicName;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<InterviewQuestion> interviewQuestions;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	public Set<Video> videos;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<PracticeTest> PracticeTest;

   @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chapter_id", nullable=false)
	private Chapter chapters;

public Topic(String topicName ,Chapter chapters) {
	super();
	this.topicName = topicName;
	this.chapters = chapters;
}


    
}
