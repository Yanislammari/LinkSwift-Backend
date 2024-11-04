package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.service.AuthService;
import com.example.linkswiftbackend.utils.config.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
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
}
