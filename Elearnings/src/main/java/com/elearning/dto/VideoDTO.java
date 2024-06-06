package com.elearning.dto;

import com.elearning.model.Topic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoDTO {

	@Column(columnDefinition = "TEXT")
	private String Title;
	@Column(columnDefinition = "TEXT")
	private String Description;
	@Column(columnDefinition = "TEXT")
	private String Url;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;

	public VideoDTO(String title, String description, String url, Topic topic) {
		super();
		Title = title;
		Description = description;
		Url = url;
		this.topic = topic;
	}

}
