package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

@Data
public class StatusDetail {

    private String state;
    private String updatedAt;
    private Equipment equipment;
    private DepartureDetail departure;
    private ArrivalDetail arrival;
    private DiversionAirport diversionAirport;

}
