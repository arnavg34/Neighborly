package com.neighborly.backend.mappers;


import com.neighborly.backend.dtos.Listing.ListingDto;
import com.neighborly.backend.dtos.Listing.CreateListingDto;
import com.neighborly.backend.dtos.Listing.ListingDto;
import com.neighborly.backend.dtos.Listing.UpdateListingDto;
import com.neighborly.backend.entities.Listing;
import com.neighborly.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ListingMapper {
    @Mapping(source = "user.id", target = "userId")
    ListingDto toDto(Listing listing);

    Listing toEntity(CreateListingDto dto);

    void updateListing(UpdateListingDto dto, @MappingTarget Listing listing);

}

