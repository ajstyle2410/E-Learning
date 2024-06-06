package com.elearning.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "chapter_id")
	private long ChapterId;
	private String ChapterName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private Course course;

	public Chapter(String chapterName, Course course) {
		super();
		ChapterName = chapterName;
		this.course = course;
	}
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "topic_id", nullable = false)
	    private Topic topic;
	   
	
}
