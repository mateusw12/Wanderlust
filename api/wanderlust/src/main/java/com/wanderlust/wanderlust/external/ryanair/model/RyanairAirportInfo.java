package com.wanderlust.wanderlust.external.ryanair.model;

import lombok.Data;

@Data
public class RyanairAirportInfo {

    private String code;
    private String name;
    private String city_code;
    private String region_code;
    private String country_code;
    private double latitude;
    private double longitude;

}
