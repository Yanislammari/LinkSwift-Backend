package com.example.linkswiftbackend.service;

import com.example.linkswiftbackend.utils.mappers.CompanyMapper;
import com.example.linkswiftbackend.model.dto.CompanyDto;
import com.example.linkswiftbackend.model.entity.CompanyEntity;
import com.example.linkswiftbackend.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    public CompanyDto getCompanyById(UUID id) {
        CompanyEntity company = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company not found"));
        return companyMapper.toDto(company);
    }

    public CompanyDto addCompany(CompanyDto company) {
        CompanyEntity companyEntity = companyMapper.toEntity(company);
        CompanyEntity savedCompany = companyRepository.save(companyEntity);
        return companyMapper.toDto(savedCompany);
    }

    public CompanyDto setCompany(UUID id, CompanyDto companyDto) {
        CompanyEntity existingCompany = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company not found"));

        existingCompany.setName(companyDto.getName());
        existingCompany.setDescription(companyDto.getDescription());
        existingCompany.setExpertiseArea(companyDto.getExpertiseArea());
        existingCompany.setWebsite(companyDto.getWebsite());
        existingCompany.setPicture(companyDto.getPicture());

        CompanyEntity updatedCompany = companyRepository.save(existingCompany);
        return companyMapper.toDto(updatedCompany);
    }

    public void deleteCompany(UUID id) {
        companyRepository.deleteById(id);
    }
}
