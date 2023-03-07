package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.filter;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class FlighStatusFilter {

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    @NotBlank
    private String startAirport;

    @NotNull
    @NotBlank
    private String endAirport;

}
