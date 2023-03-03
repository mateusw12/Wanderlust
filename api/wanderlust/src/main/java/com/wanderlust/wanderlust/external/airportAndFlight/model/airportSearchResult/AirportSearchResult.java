package com.wanderlust.wanderlust.external.airportAndFlight.model.airportSearchResult;

import com.wanderlust.wanderlust.external.airportAndFlight.model.aiportInfo.Airport;
import lombok.Data;

import java.util.List;

@Data
public class AirportSearchResult {

    private String searchBy;
    private List<Airport> items;

}
