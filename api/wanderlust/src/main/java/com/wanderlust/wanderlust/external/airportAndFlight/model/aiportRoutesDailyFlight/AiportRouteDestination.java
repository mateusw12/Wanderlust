package com.wanderlust.wanderlust.external.airportAndFlight.model.aiportRoutesDailyFlight;

import lombok.Data;

@Data
public class AiportRouteDestination {

    private String icao;
    private String iata;
    private String name;
    private String shortName;
    private String municipalityName;
    private AiportLocation location;
    private String countryCode;

}
