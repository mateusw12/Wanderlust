package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

import java.util.List;

@Data
public class FlighData {

    private List<FlightInfo> data;
    private Paging paging;

}
