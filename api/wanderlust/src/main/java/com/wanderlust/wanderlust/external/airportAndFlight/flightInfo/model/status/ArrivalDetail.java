package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

@Data
public class ArrivalDetail {

    private Time estimatedTime;
    private Time actualTime;
    private AirportInfo airport;
    private String actualTerminal;
    private String gate;
    private String baggage;

}
