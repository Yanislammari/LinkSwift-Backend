package com.example.linkswiftbackend.repository;

import com.example.linkswiftbackend.model.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> { }
