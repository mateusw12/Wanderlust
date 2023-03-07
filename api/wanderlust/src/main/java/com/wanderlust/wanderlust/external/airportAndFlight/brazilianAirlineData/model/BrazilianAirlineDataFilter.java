package com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BrazilianAirlineDataFilter {

    @NotNull
    @NotBlank
    private String company;

    @NotNull
    private Date date;

}
