package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

@Data
public class DepartureDetail {

    private Time estimatedTime;
    private Time actualTime;
    private AirportInfo airport;
    private String actualTerminal;
    private String gate;
    private String checkInCounter;

}
