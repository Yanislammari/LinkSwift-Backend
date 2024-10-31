package com.example.linkswiftbackend.service;

import com.example.linkswiftbackend.model.dto.PostDto;
import com.example.linkswiftbackend.model.entity.PostEntity;
import com.example.linkswiftbackend.repository.PostRepository;
import com.example.linkswiftbackend.repository.UserRepository;
import com.example.linkswiftbackend.utils.mappers.PostMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostMapper postMapper;

    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    public PostDto getPostById(UUID id) {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        return postMapper.toDto(post);
    }

    public PostDto addPost(PostDto post, UUID userId) {
        PostEntity postEntity = postMapper.toEntity(post);
        postEntity.setUser(userRepository.getReferenceById(userId));
        PostEntity savedPost = postRepository.save(postEntity);
        return postMapper.toDto(savedPost);
    }

    public PostDto setPost(UUID id, PostDto post) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));

        postEntity.setContent(post.getContent());
        postEntity.setCategories(post.getCategories());
        postEntity.setMedia(post.getMedia());
        postEntity.setUser(userRepository.getReferenceById(post.getUserId()));

        PostEntity savedPost = postRepository.save(postEntity);
        return postMapper.toDto(savedPost);
    }

    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
}
