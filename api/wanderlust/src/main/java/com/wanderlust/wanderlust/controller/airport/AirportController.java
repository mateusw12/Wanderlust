package com.wanderlust.wanderlust.controller.airport;

import com.wanderlust.wanderlust.external.aeroDataBox.AeroDataBoxService;
import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportInfo.Airport;
import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportRoutesDailyFlight.AiportRoutesDailyFlight;
import com.wanderlust.wanderlust.external.aeroDataBox.model.airportSearchResult.AirportSearchResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("api/aeroporto")
@Tag(name = "Consulta de aeroportos")
public class AirportController {

    @Autowired
    AeroDataBoxService aeroDataBoxService;

    @GetMapping("/info/{airportDataCode}")
    @Operation(summary = "Consulta informação do aeroporto pela IATA")
    public Airport findAirportByIataCode(@PathVariable @NotNull @NotBlank String airportDataCode) {
        return aeroDataBoxService.findAirportByIataCode(airportDataCode);
    }

    @GetMapping("/search/{airportName}")
    @Operation(summary = "Consulta informação do aeroporto pelo nome")
    public AirportSearchResult findAirportBySearchName(@PathVariable @NotNull @NotBlank String airportName) {
        return aeroDataBoxService.findAirportBySearchName(airportName);
    }

    @GetMapping("/routes/{airportIcaoCode}")
    @Operation(summary = "Consulta rotas de voos do aeroporto pelo ICAO")
    public AiportRoutesDailyFlight findAirportRoutes(@PathVariable @NotNull @NotBlank String airportIcaoCode) {
        return aeroDataBoxService.findAirportRoutes(airportIcaoCode);
    }

}
