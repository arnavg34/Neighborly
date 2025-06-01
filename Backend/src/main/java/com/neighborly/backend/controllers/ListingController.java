package com.neighborly.backend.controllers;


import com.neighborly.backend.dtos.CreateListingRequest;
import com.neighborly.backend.dtos.ListingDto;
import com.neighborly.backend.mappers.ListingMapper;
import com.neighborly.backend.repositories.ListingRepository;
import com.neighborly.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@AllArgsConstructor
@RestController
@RequestMapping("/listing")
public class ListingController {
    UserRepository userRepository;
    ListingRepository listingRepository;
    ListingMapper listingMapper;

    @PostMapping
    public ResponseEntity<ListingDto> createListing(@RequestBody CreateListingRequest request) {
        var user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) return ResponseEntity.badRequest().build();

        var listing = listingMapper.toEntity(request);
        listing.setUser(user);
        listing.setCreatedAt(Instant.now());
        listingRepository.save(listing);
        System.out.println("Saved listing ID: " + listing.getId());
        System.out.println("DTO ID: " + listingMapper.toDto(listing).getId());
        return ResponseEntity.ok(listingMapper.toDto(listing));
    }
}
