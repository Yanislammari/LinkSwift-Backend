package com.example.linkswiftbackend.utils.mappers;

import com.example.linkswiftbackend.model.dto.OfferDto;
import com.example.linkswiftbackend.model.entity.CompanyEntity;
import com.example.linkswiftbackend.model.entity.OfferEntity;
import com.example.linkswiftbackend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    @Autowired
    private CompanyRepository companyRepository;

    public OfferDto toDto(OfferEntity offer) {
        return new OfferDto(
                offer.getId(),
                offer.getName(),
                offer.getDescription(),
                offer.getSalary(),
                offer.getGradeRequired(),
                offer.isRemotePossible(),
                offer.isInternshipPossible(),
                offer.isAlternationPossible(),
                offer.getPublicationDate(),
                offer.getCompany().getId()
        );
    }

    public OfferEntity toEntity(OfferDto offer) {
        CompanyEntity company = companyRepository.getReferenceById(offer.getCompanyId());

        return new OfferEntity(
                offer.getId(),
                offer.getName(),
                offer.getDescription(),
                offer.getSalary(),
                offer.getGradeRequired(),
                offer.isInternshipPossible(),
                offer.isInternshipPossible(),
                offer.isAlternationPossible(),
                offer.getPublicationDate(),
                company
        );
    }
}
