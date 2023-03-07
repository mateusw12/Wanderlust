package com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.model;

import lombok.Data;

@Data
public class BrazilianArilineData {

    private String aicraft_type;
    private String arrival_icao;
    private String callsign;
    private String code;
    private String cruise_flight_level;
    private String cruise_speed;
    private String departure_icao;
    private String enroute_time;
    private String eobt;
    private String flight_number;
    private String remarks;
    private String route;
    private String wake_turbulence;
    private BrazilianAirlineDataFlightDays flight_days;

}
