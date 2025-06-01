package com.neighborly.backend.exceptions;

public class ListingExistsException extends RuntimeException {
    public ListingExistsException() {
        super("Listing already exists: ");
    }
}
