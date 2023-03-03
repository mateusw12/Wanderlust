package com.wanderlust.wanderlust.external.airportAndFlight.ryanair.model;

import lombok.Data;

@Data
public class RyanairAirportRoutes {

    private String code;
    private String name;
    private String city_code;
    private String city_name;
    private String region_code;
    private String region_name;
    private String country_code;
    private String country_name;
    private double latitude;
    private double longitude;

}
