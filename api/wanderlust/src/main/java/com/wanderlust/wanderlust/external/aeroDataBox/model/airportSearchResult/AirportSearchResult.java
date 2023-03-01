package com.wanderlust.wanderlust.external.aeroDataBox.model.airportSearchResult;

import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportInfo.Airport;
import lombok.Data;

import java.util.List;

@Data
public class AirportSearchResult {

    private String searchBy;
    private List<Airport> items;

}
