package com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace.preview;

public enum AirBnbPropertyPreview {

    WIFI("Wifi"),
    SELFCHECKIN("Self check-in");

    private final String description;

    AirBnbPropertyPreview(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
