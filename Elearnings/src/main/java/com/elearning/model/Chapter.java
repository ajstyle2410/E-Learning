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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "chapter_id")
	private long ChapterId;
	private String ChapterName;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", nullable=false)
	private Course course;
    
    
    @OneToMany(mappedBy="chapters")
    private    Set<Topic> topic;

}
