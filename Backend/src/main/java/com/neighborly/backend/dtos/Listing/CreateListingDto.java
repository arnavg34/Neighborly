package com.neighborly.backend.dtos.Listing;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateListingDto {
    private String title;
    private String description;
    private int price;
    private UUID userId;
}

