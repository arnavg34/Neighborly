package com.neighborly.backend.controllers;


import com.neighborly.backend.dtos.Listing.CreateListingDto;
import com.neighborly.backend.dtos.Listing.ListingDto;
import com.neighborly.backend.dtos.Listing.UpdateListingDto;
import com.neighborly.backend.exceptions.ListingExistsException;
import com.neighborly.backend.exceptions.ListingNotFoundException;
import com.neighborly.backend.mappers.ListingMapper;
import com.neighborly.backend.services.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/listing")
public class ListingController {
    ListingMapper listingMapper;
    ListingService listingService;

    @GetMapping("/{id}")
    public ResponseEntity<ListingDto> getListing(@PathVariable UUID id) {
        var listing = listingService.findById(id);
        return ResponseEntity.ok(listingMapper.toDto(listing));
    }

    @PostMapping
    public ResponseEntity<ListingDto> createListing(
            @RequestBody CreateListingDto request,
            UriComponentsBuilder uriBuilder
    ) {
        var listingDto = listingService.createListing(request);
        var uri = uriBuilder.path("/listing/{id}").buildAndExpand(listingDto.getId()).toUri();
        return ResponseEntity.created(uri).body(listingDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable(name="id") UUID id) {
        listingService.deleteListing(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ListingDto> updateListing(@PathVariable UUID id, @RequestBody UpdateListingDto dto) {
        var updatedListing = listingService.updateListing(id, dto);
        return ResponseEntity.ok(updatedListing);
    }
    @ExceptionHandler({ListingExistsException.class})
    public ResponseEntity<Map<String,String>> handleListingExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of("error", "Listing already exists."));
    }
    @ExceptionHandler({ListingNotFoundException.class})
    public ResponseEntity<Map<String,String>> handleNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "Listing does not exist."));
    }
}
