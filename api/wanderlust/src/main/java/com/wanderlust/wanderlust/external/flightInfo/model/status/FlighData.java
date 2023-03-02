package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

import java.util.List;

@Data
public class FlighData {

    private List<FlightInfo> data;
    private Paging paging;

}
