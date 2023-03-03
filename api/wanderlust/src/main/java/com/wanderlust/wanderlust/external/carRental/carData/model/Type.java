package com.wanderlust.wanderlust.external.carRental.carData.model;

public enum Type {
    SUV("SUV"),
    CONVERTIBLE("Convertible"),
    PICKUP("Pickup"),
    VAN_MINIVAN("Van/Minivan"),
    WAGON("Wagon"),
    SEDAN("Sedan"),
    COUPE("Coupe"),
    HATCHBACK("Hatchback");

    private final String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}