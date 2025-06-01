package com.neighborly.backend.repositories;

import com.neighborly.backend.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListingRepository extends JpaRepository<Listing, UUID> {
    boolean existsByTitleAndUserId(String title, UUID userId);
}
