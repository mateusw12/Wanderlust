package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

@Data
public class DepartureInfo {

    private AirportInfo airport;
    private String terminal;
    private String date;
    private String passengerLocalTime;

}
