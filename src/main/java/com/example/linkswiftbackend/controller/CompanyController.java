package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.CompanyDto;
import com.example.linkswiftbackend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getAllCompany() {
        try {
            List<CompanyDto> companies = companyService.getAllCompanies();
            return ResponseEntity.ok(companies);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while retrieving companies.\"}");
        }
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<?> getCompanyById(@PathVariable("companyId") UUID companyId) {
        try {
            CompanyDto company = companyService.getCompanyById(companyId);
            return ResponseEntity.ok(company);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Company not found\"}");
        }
    }

    @PostMapping("/addCompany")
    public ResponseEntity<?> addCompany(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("expertiseArea") String expertiseArea, @RequestParam("website") String website, @RequestParam("picture") MultipartFile picture) {
        try {
            byte[] imageBytes = picture.getBytes();
            CompanyDto company = new CompanyDto(null, name, description, expertiseArea, website, imageBytes);
            CompanyDto savedCompany = companyService.addCompany(company);
            return ResponseEntity.ok(savedCompany);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to add company.\"}");
        }
    }
}
