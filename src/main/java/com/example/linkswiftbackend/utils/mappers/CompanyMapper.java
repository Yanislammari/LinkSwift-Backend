package com.example.linkswiftbackend.utils.mappers;

import com.example.linkswiftbackend.model.dto.CompanyDto;
import com.example.linkswiftbackend.model.entity.CompanyEntity;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyDto toDto(CompanyEntity company) {
        return new CompanyDto(
                company.getId(),
                company.getName(),
                company.getDescription(),
                company.getExpertiseArea(),
                company.getWebsite(),
                company.getPicture()
        );
    }

    public CompanyEntity toEntity(CompanyDto company) {
        return new CompanyEntity(
                company.getId(),
                company.getName(),
                company.getDescription(),
                company.getExpertiseArea(),
                company.getWebsite(),
                company.getPicture()
        );
    }
}
