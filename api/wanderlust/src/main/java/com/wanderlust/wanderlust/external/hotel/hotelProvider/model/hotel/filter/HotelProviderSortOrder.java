package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.filter;

public enum HotelProviderSortOrder {

    REVIEW("REVIEW"),
    RECOMMENDED("RECOMMENDED"),
    DISTANCE("DISTANCE"),
    PRICELOWTOHIGH("PRICE_LOW_TO_HIGH"),
    PROPERTYCLASS("PROPERTY_CLASS"),
    PRICERELEVANT("PRICE_RELEVAT");

    private final String description;

    HotelProviderSortOrder(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
