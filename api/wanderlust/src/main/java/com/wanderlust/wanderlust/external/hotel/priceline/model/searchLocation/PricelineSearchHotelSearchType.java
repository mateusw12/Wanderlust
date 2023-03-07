package com.wanderlust.wanderlust.external.hotel.priceline.model.searchLocation;

public enum PricelineSearchHotelSearchType {

    ALL("ALL"),
    CITY("CITY"),
    AIRPORT("AIRPORT"),
    POI("POI"),
    HOTEL("HOTEL");

    private final String description;

    PricelineSearchHotelSearchType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
