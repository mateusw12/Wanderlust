package com.wanderlust.wanderlust.external.flightInfo.filter;

import lombok.Data;

import java.util.Date;

@Data
public class FlighStatusFilter {

    private Date startDate;
    private Date endDate;
    private String startAirport;
    private String endAirport;

}
