package com.neighborly.backend.exceptions;

public class ListingNotFoundException extends RuntimeException {
    public ListingNotFoundException() {
        super("Listing does not exist");
    }
}
