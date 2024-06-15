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
    private Set<Video> videos;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<PracticeTest> PracticeTest;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<Chapter> chapters;

    public Topic(String topicName, Set<InterviewQuestion> interviewQuestions, Set<Assignment> assignments,
                 Set<Video> videos, Set<PracticeTest> practiceTest, Set<Chapter> chapters) {
        super();
        this.topicName = topicName;
        this.interviewQuestions = interviewQuestions;
        this.assignments = assignments;
        this.videos = videos;
        PracticeTest = practiceTest;
        this.chapters = chapters;
    }
}
