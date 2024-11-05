package com.example.linkswiftbackend.controller;

import com.example.linkswiftbackend.model.dto.OfferDto;
import com.example.linkswiftbackend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{offerId}")
    public ResponseEntity<?> getOfferById(@PathVariable("offerId") UUID offerId) {
        try {
            OfferDto offer = offerService.getOfferById(offerId);
            return ResponseEntity.ok(offer);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Offer not found\"}");
        }
    }

    @PostMapping("/addOffer/{companyId}")
    public ResponseEntity<?> addOffer(@PathVariable("companyId") UUID companyId, OfferDto offer) {
        try {
            OfferDto savedOffer = offerService.addOffer(offer, companyId);
            return ResponseEntity.ok(savedOffer);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to add offer.\"}");
        }
    }

    @PutMapping("/editOffer/{offerId}")
    public ResponseEntity<?> editOffer(@PathVariable("offerId") UUID offerId, OfferDto offer) {
        try {
            OfferDto setOffer = offerService.setOffer(offerId, offer);
            return ResponseEntity.ok(setOffer);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Offer not found\"}");
        }
    }
}
