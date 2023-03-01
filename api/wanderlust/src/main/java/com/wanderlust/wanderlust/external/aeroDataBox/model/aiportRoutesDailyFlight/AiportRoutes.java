package com.wanderlust.wanderlust.external.aeroDataBox.model.aiportRoutesDailyFlight;

import lombok.Data;

import java.util.List;

@Data
public class AiportRoutes {

    private List<AiportRouteDestination> destination;
    private Double averageDailyFlights;
    private List<AirportOperators> operators;

}
