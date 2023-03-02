package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

@Data
public class DepartureInfo {

    private AirportInfo airport;
    private String terminal;
    private String date;
    private String passengerLocalTime;

}
