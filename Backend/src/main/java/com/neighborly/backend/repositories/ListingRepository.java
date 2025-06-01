package com.neighborly.backend.repositories;

import com.neighborly.backend.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
