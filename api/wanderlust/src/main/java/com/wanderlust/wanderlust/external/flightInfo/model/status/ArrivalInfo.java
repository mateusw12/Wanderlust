package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

@Data
public class ArrivalInfo {

    private AirportInfo airport;
    private String terminal;
    private String date;
    private String passengerLocalTime;

}
