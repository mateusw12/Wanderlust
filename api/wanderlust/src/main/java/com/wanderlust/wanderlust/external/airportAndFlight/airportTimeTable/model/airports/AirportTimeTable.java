package com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirportTimeTable {

    @JsonProperty("IATACode")
    private String iataCode;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("State")
    private String state;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Latitude")
    private String latitude;

    @JsonProperty("Longitude")
    private String longitude;

}
