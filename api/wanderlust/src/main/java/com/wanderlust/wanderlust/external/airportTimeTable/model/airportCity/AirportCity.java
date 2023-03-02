package com.wanderlust.wanderlust.external.airportTimeTable.model.airportCity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirportCity {

    @JsonProperty("IATACode")
    private String iataCode;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("State")
    private String state;

    @JsonProperty("Name")
    private String cityName;

}
