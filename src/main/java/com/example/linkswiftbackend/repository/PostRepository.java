package com.example.linkswiftbackend.repository;

import com.example.linkswiftbackend.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> { }
