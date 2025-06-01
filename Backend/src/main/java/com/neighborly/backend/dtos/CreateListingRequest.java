package com.neighborly.backend.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateListingRequest {
    private String title;
    private String description;
    private Integer price;
    private UUID userId;
}
