package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.PostDto;
import com.example.linkswiftbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable("postId") UUID postId) {
        try {
            PostDto post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Post not found\"}");
        }
    }

    @PostMapping("/addPost/{userId}")
    public ResponseEntity<?> addPost(@RequestParam("content") String content, @RequestParam("categories") List<String> categories, @RequestParam(value = "media", required = false) MultipartFile media, @PathVariable("userId") UUID userId) {
        try {
            byte[] mediaBytes = null;
            if(media != null && !media.isEmpty()) {
                mediaBytes = media.getBytes();
            }
            PostDto post = new PostDto(null, content, categories, mediaBytes, userId);
            PostDto addedPost = postService.addPost(post, userId);
            return ResponseEntity.ok(addedPost);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to add post.\"}");
        }
    }

    @PutMapping("/editPost/{postId}")
    public ResponseEntity<?> editPost(@PathVariable("postId") UUID postId, @RequestParam("content") String content, @RequestParam("categories") List<String> categories, @RequestParam("media") MultipartFile media, @RequestParam("userId") UUID userId) {
        try {
            byte[] mediaBytes = media.getBytes();
            PostDto post = new PostDto(null, content, categories, mediaBytes, userId);
            PostDto setPost = postService.setPost(postId, post);
            return ResponseEntity.ok(setPost);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Post not found\"}");
        }
    }
}
