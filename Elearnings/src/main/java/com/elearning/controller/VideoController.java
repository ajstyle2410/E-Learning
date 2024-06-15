package com.elearning.controller;

import com.elearning.dto.VideoDTO;
import com.elearning.model.Video;
import com.elearning.service.VideoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoServiceInterface videoService;

    @PostMapping("/addvideo") // Mapping to handle POST requests for adding a video
    public ResponseEntity<String> addVideo(@RequestBody VideoDTO videoDTO) {
    	System.err.println(videoDTO.toString());
        String response = videoService.addVideo(videoDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getVideos();
        return ResponseEntity.ok(videos);
    }
}
