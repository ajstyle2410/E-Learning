package com.elearning.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoDTO {

    private String title;
    private String description;
    private String url;
    private Integer topicId;

    public VideoDTO(String title, String description, String url, Integer topicId) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.topicId = topicId;
    }
}
