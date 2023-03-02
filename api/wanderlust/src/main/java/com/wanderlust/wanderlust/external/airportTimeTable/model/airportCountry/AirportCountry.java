package com.wanderlust.wanderlust.external.airportTimeTable.model.airportCountry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirportCountry {

    @JsonProperty("IATACode")
    private String iataCode;

    @JsonProperty("Name")
    private String countryName;

}
