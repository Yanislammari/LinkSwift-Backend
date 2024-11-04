package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.UserDto;
import com.example.linkswiftbackend.model.enums.UserGrade;
import com.example.linkswiftbackend.model.enums.UserType;
import com.example.linkswiftbackend.service.UserService;
import com.example.linkswiftbackend.utils.config.security.AuthVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserDto> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while retrieving users.\"}");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") UUID userId) {
        try {
            UserDto user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        }
    }

    @PutMapping("/editUser/{userId}")
    public ResponseEntity<?> editUser(@PathVariable("userId") UUID userId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("type") UserType type, @RequestParam("job") String job, @RequestParam("searchJob") boolean searchJob, @RequestParam("grade") UserGrade grade, @RequestParam("course") String course, @RequestParam("profilePicture") MultipartFile profilePicture, @RequestParam("companyId") UUID companyId, @RequestParam("schoolId") UUID schoolId) {
        try {
            if(AuthVerification.isValidEmail(email)) {
                String jsonResponse = "{\"message\": \"Invalid email format\"}";
                return ResponseEntity.badRequest().body(jsonResponse);
            }
            if(AuthVerification.isValidPassword(password)) {
                String jsonResponse = "{\"message\": \"Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character\"}";
                return ResponseEntity.badRequest().body(jsonResponse);
            }
            byte[] profilePicBytes = profilePicture != null ? profilePicture.getBytes() : null;
            UserDto user = new UserDto(null, firstName, lastName, email, password, type, job, searchJob, grade, course, profilePicBytes, companyId, schoolId);
            UserDto setUser = userService.setUser(userId, user);
            return ResponseEntity.ok(setUser);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") UUID userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("{\"message\": \"User successfully deleted\"}");
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found\"}");
        }
    }
}
