package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.SchoolDto;
import com.example.linkswiftbackend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public ResponseEntity<?> getAllSchools() {
        try {
            List<SchoolDto> schools = schoolService.getAllSchools();
            return ResponseEntity.ok(schools);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while retrieving schools.\"}");
        }
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<?> getSchoolById(@PathVariable("schoolId") UUID schoolId) {
        try {
            SchoolDto school = schoolService.getSchoolById(schoolId);
            return ResponseEntity.ok(school);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"School not found\"}");
        }
    }
}
