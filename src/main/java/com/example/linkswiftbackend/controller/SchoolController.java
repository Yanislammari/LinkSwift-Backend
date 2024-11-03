package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.SchoolDto;
import com.example.linkswiftbackend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping("/addSchool")
    public ResponseEntity<?> addSchool(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("website") String website, @RequestParam("picture") MultipartFile picture) {
        try {
            byte[] imageBytes = picture.getBytes();
            SchoolDto school = new SchoolDto(null, name, description, website, imageBytes);
            SchoolDto savedSchool = schoolService.addSchool(school);
            return ResponseEntity.ok(savedSchool);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to add school.\"}");
        }
    }

    @PutMapping("/editSchool/{schoolId}")
    public ResponseEntity<?> editSchool(@PathVariable("schoolId") UUID schoolId, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("website") String website, @RequestParam("picture") MultipartFile picture) {
        try {
            byte[] imageBytes = picture.getBytes();
            SchoolDto school = new SchoolDto(null, name, description, website, imageBytes);
            SchoolDto setSchool = schoolService.setSchool(schoolId, school);
            return ResponseEntity.ok(setSchool);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"School not found\"}");
        }
    }

    @DeleteMapping("/deleteSchool/{schoolId}")
    public ResponseEntity<String> deleteSchool(@PathVariable("schoolId") UUID schoolId) {
        try {
            schoolService.deleteSchool(schoolId);
            return ResponseEntity.ok("{\"message\": \"School successfully deleted\"}");
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"School not found\"}");
        }
    }
}
