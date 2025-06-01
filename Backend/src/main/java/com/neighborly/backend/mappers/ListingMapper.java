package com.neighborly.backend.mappers;


import com.neighborly.backend.dtos.CreateListingRequest;
import com.neighborly.backend.dtos.ListingDto;
import com.neighborly.backend.entities.Listing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListingMapper {
    Listing toEntity(CreateListingRequest dto);
    ListingDto toDto(Listing listing);
}
