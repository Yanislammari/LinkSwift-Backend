package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.CompanyDto;
import com.example.linkswiftbackend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
}
