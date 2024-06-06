package com.elearning.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Video {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private long VideoId;
	    @Column(columnDefinition = "TEXT")
	   private String Title;
	    @Column(columnDefinition = "TEXT")
	   private String Description;
	    @Column(columnDefinition = "TEXT")
	   private String Url;
	   
	   @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "topic_id", nullable = false)
	    private Topic topic;

	public Video(String title, String description, String url, Topic topic) {
		super();
		Title = title;
		Description = description;
		Url = url;
		this.topic = topic;
	}
	   
}
