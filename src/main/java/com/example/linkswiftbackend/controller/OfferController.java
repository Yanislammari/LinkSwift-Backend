package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.OfferDto;
import com.example.linkswiftbackend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping
    public ResponseEntity<?> getAllOffers() {
        try {
            List<OfferDto> offers = offerService.getAllOffers();
            return ResponseEntity.ok(offers);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error occurred while retrieving offers.\"}");
        }
    }
}
