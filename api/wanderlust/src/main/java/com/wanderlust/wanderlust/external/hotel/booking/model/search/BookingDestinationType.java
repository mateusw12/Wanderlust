package com.wanderlust.wanderlust.external.hotel.booking.model.search;

public enum BookingDestinationType {

    CITY("city"),
    REGION("region"),
    LANDMARK("landmark"),
    DISTRICT("district"),
    HOTEL("hotel"),
    COUNTRY("country"),
    AIRPORT("airport"),
    LATLONG("latlong");

    private final String description;

    BookingDestinationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
