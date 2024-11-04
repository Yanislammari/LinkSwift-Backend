package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.PostDto;
import com.example.linkswiftbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        try {
            List<PostDto> posts = postService.getAllPosts();
            return ResponseEntity.ok(posts);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while retrieving posts.\"}");
        }
    }
}
