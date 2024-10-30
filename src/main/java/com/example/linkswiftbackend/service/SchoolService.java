package com.example.linkswiftbackend.service;

import com.example.linkswiftbackend.model.dto.SchoolDto;
import com.example.linkswiftbackend.model.entity.SchoolEntity;
import com.example.linkswiftbackend.repository.SchoolRepository;
import com.example.linkswiftbackend.utils.mappers.SchoolMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SchoolMapper schoolMapper;

    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toDto)
                .collect(Collectors.toList());
    }

    public SchoolDto getSchoolById(UUID id) {
        SchoolEntity school = schoolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("School not found"));
        return schoolMapper.toDto(school);
    }

    public SchoolDto addSchool(SchoolDto school) {
        SchoolEntity schoolEntity = schoolMapper.toEntity(school);
        SchoolEntity savedSchool = schoolRepository.save(schoolEntity);
        return schoolMapper.toDto(savedSchool);
    }

    public SchoolDto setSchool(UUID id, SchoolDto school) {
        SchoolEntity existingSchool = schoolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("School not found"));

        existingSchool.setName(school.getName());
        existingSchool.setDescription(school.getDescription());
        existingSchool.setWebsite(school.getWebsite());
        existingSchool.setPicture(school.getPicture());

        SchoolEntity updatedSchool = schoolRepository.save(existingSchool);
        return schoolMapper.toDto(updatedSchool);
    }

    public void deleteSchool(UUID id) {
        schoolRepository.deleteById(id);
    }
}
