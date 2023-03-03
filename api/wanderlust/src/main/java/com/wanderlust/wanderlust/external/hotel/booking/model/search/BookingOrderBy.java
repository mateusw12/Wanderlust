package com.wanderlust.wanderlust.external.hotel.booking.model.search;

public enum BookingOrderBy {

    POPULARITY("popularity"),
    CLASSASCENDING("class_ascending"),
    CLASSDESCENDING("class_descending"),
    DISTANCE("distance"),
    PRICE("price");

    private final String description;

    BookingOrderBy(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
