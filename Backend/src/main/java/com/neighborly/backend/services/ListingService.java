package com.neighborly.backend.services;


import com.neighborly.backend.dtos.Listing.CreateListingDto;
import com.neighborly.backend.dtos.Listing.ListingDto;
import com.neighborly.backend.dtos.Listing.UpdateListingDto;
import com.neighborly.backend.entities.Listing;
import com.neighborly.backend.exceptions.ListingExistsException;
import com.neighborly.backend.exceptions.ListingNotFoundException;
import com.neighborly.backend.mappers.ListingMapper;
import com.neighborly.backend.repositories.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;
    private final UserService userService;
    public Listing findById(UUID id) {
        var listing = listingRepository.findById(id).orElse(null);
        if (listing == null) {
            throw new ListingNotFoundException();
        }
        return listing;
    }

    public ListingDto createListing(CreateListingDto request) {
        if (listingRepository.existsByTitleAndUserId(request.getTitle(), request.getUserId())) {
            throw new ListingExistsException();
        }
        var user = userService.findById(request.getUserId());
        var listing = listingMapper.toEntity(request);
        listing.setUser(user);
        listing.setCreatedAt(Instant.now());
        listingRepository.save(listing);
        return listingMapper.toDto(listing);
    }
    public void deleteListing(UUID id) {
        var listing = findById(id);
        listingRepository.delete(listing);
    }
    public ListingDto updateListing(UUID id, UpdateListingDto dto) {
        var listing = findById(id);

        if (!listing.getUser().getId().equals(dto.getUserId())) {
            throw new RuntimeException("You do not have permission to update this listing.");
        }

        listingMapper.updateListing(dto, listing);
        listingRepository.save(listing);
        return listingMapper.toDto(listing);
    }
}
