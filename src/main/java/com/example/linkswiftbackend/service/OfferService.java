package com.example.linkswiftbackend.service;

import com.example.linkswiftbackend.model.dto.OfferDto;
import com.example.linkswiftbackend.model.entity.OfferEntity;
import com.example.linkswiftbackend.repository.CompanyRepository;
import com.example.linkswiftbackend.repository.OfferRepository;
import com.example.linkswiftbackend.utils.mappers.OfferMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private OfferMapper offerMapper;

    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream()
                .map(offerMapper::toDto)
                .collect(Collectors.toList());
    }

    public OfferDto getOfferById(UUID id) {
        OfferEntity offer = offerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Offer not found"));
        return offerMapper.toDto(offer);
    }

    public OfferDto addOffer(OfferDto offer, UUID companyId) {
        OfferEntity offerEntity = offerMapper.toEntity(offer);
        offerEntity.setCompany(companyRepository.getReferenceById(companyId));
        OfferEntity offerSaved = offerRepository.save(offerEntity);
        return offerMapper.toDto(offerSaved);
    }

    public OfferDto setOffer(UUID id, OfferDto offer) {
        OfferEntity existingOffer = offerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Offer not found"));

        existingOffer.setName(offer.getName());
        existingOffer.setDescription(offer.getDescription());
        existingOffer.setSalary(offer.getSalary());
        existingOffer.setRemotePossible(offer.isRemotePossible());
        existingOffer.setRemotePossible(offer.isRemotePossible());
        existingOffer.setInternshipPossible(offer.isInternshipPossible());
        existingOffer.setAlternationPossible(offer.isAlternationPossible());
        existingOffer.setPublicationDate(offer.getPublicationDate());
        existingOffer.setCompany(companyRepository.getReferenceById(offer.getCompanyId()));

        OfferEntity savedOffer = offerRepository.save(existingOffer);
        return offerMapper.toDto(savedOffer);
    }

    public void deleteOffer(UUID id) {
        offerRepository.deleteById(id);
    }
}
