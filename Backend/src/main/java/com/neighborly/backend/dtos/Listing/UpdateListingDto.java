package com.neighborly.backend.dtos.Listing;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateListingDto {
    private String title;
    private String description;
    private Integer price;
    private UUID userId;
}
