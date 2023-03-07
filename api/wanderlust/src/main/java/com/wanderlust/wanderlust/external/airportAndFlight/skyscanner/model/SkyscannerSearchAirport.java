package com.wanderlust.wanderlust.external.airportAndFlight.skyscanner.model;

import lombok.Data;

import java.util.List;

@Data
public class SkyscannerSearchAirport {

    private Boolean status;
    private String mesage;
    private List<SkyscannerSearchAirportData> data;

}
