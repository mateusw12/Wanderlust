package com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AirportResponse {

    @JsonProperty("Airport")
    private List<AirportName> airportNames;

}
