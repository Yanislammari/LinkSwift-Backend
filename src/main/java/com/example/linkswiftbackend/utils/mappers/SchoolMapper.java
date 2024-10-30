package com.example.linkswiftbackend.utils.mappers;

import com.example.linkswiftbackend.model.dto.SchoolDto;
import com.example.linkswiftbackend.model.entity.SchoolEntity;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {
    public SchoolDto toDto(SchoolEntity school) {
        return new SchoolDto(
                school.getId(),
                school.getName(),
                school.getDescription(),
                school.getWebsite(),
                school.getPicture()
        );
    }

    public SchoolEntity toEntity(SchoolDto school) {
        return new SchoolEntity(
                school.getId(),
                school.getName(),
                school.getDescription(),
                school.getWebsite(),
                school.getPicture()
        );
    }
}
