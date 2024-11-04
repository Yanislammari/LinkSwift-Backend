package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.UserDto;
import com.example.linkswiftbackend.model.enums.UserType;
import com.example.linkswiftbackend.service.AuthService;
import com.example.linkswiftbackend.utils.config.security.AuthVerification;
import com.example.linkswiftbackend.utils.config.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<String> getUserIdFromToken(@RequestHeader("Authorization") String token) {
        try {
            String cleanedToken = token.startsWith("Bearer ") ? token.substring(7) : token;
            String userId = jwtUtil.extractUserId(cleanedToken);
            String jsonResponse = String.format("{\"userId\": \"%s\"}", userId);
            return ResponseEntity.ok(jsonResponse);
        }
        catch(Exception e) {
            String jsonResponse = String.format("{\"message\": \"Error extracting user ID: %s\"}", e.getMessage());
            return ResponseEntity.badRequest().body(jsonResponse);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            if(AuthVerification.isValidEmail(email)) {
                String jsonResponse = "{\"message\": \"Invalid email format\", \"token\": null}";
                return ResponseEntity.badRequest().body(jsonResponse);
            }
            if(AuthVerification.isValidPassword(password)) {
                String jsonResponse = "{\"message\": \"Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character\", \"token\": null}";
                return ResponseEntity.badRequest().body(jsonResponse);
            }
            byte[] profilePicBytes = profilePicture != null ? profilePicture.getBytes() : null;
            UserDto userDto = new UserDto(UUID.randomUUID(), firstName, lastName, email, password, UserType.USER, null, false, null, null, profilePicBytes, null, null);
            String jwtToken = authService.register(userDto);
            String jsonResponse = String.format("{\"message\": \"Registration successful\", \"token\": \"%s\"}", jwtToken);
            return ResponseEntity.ok(jsonResponse);
        }
        catch(Exception e) {
            String jsonResponse = String.format("{\"message\": \"Error during registration: %s\", \"token\": null}", e.getMessage());
            return ResponseEntity.badRequest().body(jsonResponse);
        }
    }
}
