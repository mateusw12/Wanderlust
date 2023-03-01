package com.wanderlust.wanderlust.controller.airport;

import com.wanderlust.wanderlust.external.aeroDataBox.AeroDataBoxService;
import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportInfo.Airport;
import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportRoutesDailyFlight.AiportRoutesDailyFlight;
import com.wanderlust.wanderlust.external.aeroDataBox.model.airportSearchResult.AirportSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("api/aeroporto")
public class AirportController {

    @Autowired
    AeroDataBoxService aeroDataBoxService;

    @GetMapping("info/{airportDataCode}")
    public Airport findAirportByIataCode(@PathVariable @NotNull @NotBlank String airportDataCode) {
        return aeroDataBoxService.findAirportByIataCode(airportDataCode);
    }

    @GetMapping("search/{airportName}")
    public AirportSearchResult findAirportBySearchName(@PathVariable @NotNull @NotBlank String airportName) {
        return aeroDataBoxService.findAirportBySearchName(airportName);
    }

    @GetMapping("routes/{airportIcaoCode}")
    public AiportRoutesDailyFlight findAirportRoutes(@PathVariable @NotNull @NotBlank String airportIcaoCode) {
        return aeroDataBoxService.findAirportRoutes(airportIcaoCode);
    }

}
