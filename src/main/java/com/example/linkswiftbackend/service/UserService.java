package com.example.linkswiftbackend.service;

import com.example.linkswiftbackend.model.dto.UserDto;
import com.example.linkswiftbackend.model.entity.UserEntity;
import com.example.linkswiftbackend.repository.CompanyRepository;
import com.example.linkswiftbackend.repository.SchoolRepository;
import com.example.linkswiftbackend.repository.UserRepository;
import com.example.linkswiftbackend.utils.mappers.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    public UserDto setUser(UUID id, UserDto user) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setType(user.getType());
        existingUser.setJob(user.getJob());
        existingUser.setSearchJob(user.isSearchJob());
        existingUser.setGrade(user.getGrade());
        existingUser.setCourse(user.getCourse());
        existingUser.setProfilePicture(user.getProfilePicture());
        existingUser.setCompany(companyRepository.getReferenceById(user.getCompanyId()));
        existingUser.setSchool(schoolRepository.getReferenceById(user.getSchoolId()));

        UserEntity savedUser = userRepository.save(existingUser);
        return userMapper.toDto(savedUser);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
