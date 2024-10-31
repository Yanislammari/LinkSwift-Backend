package com.example.linkswiftbackend.utils.mappers;

import com.example.linkswiftbackend.model.dto.PostDto;
import com.example.linkswiftbackend.model.entity.PostEntity;
import com.example.linkswiftbackend.model.entity.UserEntity;
import com.example.linkswiftbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    @Autowired
    private UserRepository userRepository;

    public PostDto toDto(PostEntity post) {
        return new PostDto(
                post.getId(),
                post.getContent(),
                post.getCategories(),
                post.getMedia(),
                post.getUser().getId()
        );
    }

    public PostEntity toEntity(PostDto post) {
        UserEntity user = userRepository.getReferenceById(post.getUserId());

        return new PostEntity(
                post.getId(),
                post.getContent(),
                post.getCategories(),
                post.getMedia(),
                user
        );
    }
}
