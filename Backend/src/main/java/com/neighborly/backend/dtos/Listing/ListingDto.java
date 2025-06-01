package com.neighborly.backend.dtos.Listing;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Data
public class ListingDto {
    private UUID id;
    private String title;
    private String description;
    private int price;
    private UUID userId;
}

