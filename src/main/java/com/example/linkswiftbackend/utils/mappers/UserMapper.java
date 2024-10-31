package com.example.linkswiftbackend.utils.mappers;

import com.example.linkswiftbackend.model.dto.UserDto;
import com.example.linkswiftbackend.model.entity.UserEntity;
import com.example.linkswiftbackend.model.entity.CompanyEntity;
import com.example.linkswiftbackend.model.entity.SchoolEntity;
import com.example.linkswiftbackend.repository.CompanyRepository;
import com.example.linkswiftbackend.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public UserDto toDto(UserEntity user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                null,
                user.getType(),
                user.getJob(),
                user.isSearchJob(),
                user.getGrade(),
                user.getCourse(),
                user.getProfilePicture(),
                user.getCompany() != null ? user.getCompany().getId() : null,
                user.getSchool() != null ? user.getSchool().getId() : null
        );
    }

    public UserEntity toEntity(UserDto user) {
        CompanyEntity company = companyRepository.getReferenceById(user.getCompanyId());
        SchoolEntity school = schoolRepository.getReferenceById(user.getSchoolId());

        return new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getType(),
                user.getJob(),
                user.isSearchJob(),
                user.getGrade(),
                user.getCourse(),
                user.getProfilePicture(),
                company,
                school
        );
    }
}
