package com.wanderlust.wanderlust.controller.airport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wanderlust.wanderlust.external.aeroDataBox.AeroDataBoxService;
import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportInfo.Airport;
import com.wanderlust.wanderlust.external.aeroDataBox.model.aiportRoutesDailyFlight.AiportRoutesDailyFlight;
import com.wanderlust.wanderlust.external.aeroDataBox.model.airportSearchResult.AirportSearchResult;
import com.wanderlust.wanderlust.external.airportTimeTable.AirportTimeTableService;
import com.wanderlust.wanderlust.external.airportTimeTable.model.airportCity.AirportCity;
import com.wanderlust.wanderlust.external.airportTimeTable.model.airportCountry.AirportCountry;
import com.wanderlust.wanderlust.external.airportTimeTable.model.airports.AirportTimeTable;
import com.wanderlust.wanderlust.external.airportTimeTable.model.country.AirportResponse;
import com.wanderlust.wanderlust.external.flightInfo.FlightInfoService;
import com.wanderlust.wanderlust.external.flightInfo.model.status.FlighData;
import com.wanderlust.wanderlust.external.flightInfo.filter.FlighStatusFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/aeroporto")
@Tag(name = "Consulta de aeroportos")
public class AirportController {

    @Autowired
    AeroDataBoxService aeroDataBoxService;

    @Autowired
    FlightInfoService flightInfoService;

    @Autowired
    AirportTimeTableService airportTimeTableService;

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

    @GetMapping
    @Operation(summary = "Consulta todos os aeroportos")
    public List<AirportTimeTable> findAirports() throws JsonProcessingException {
        return airportTimeTableService.findAirports();
    }

    @GetMapping("/country/{countryIataCode}")
    @Operation(summary = "Consulta todos os aeroportos")
    public AirportResponse findAirports(@PathVariable @NotNull @NotBlank String countryIataCode) throws JsonProcessingException {
        return airportTimeTableService.findAirportsByCountry(countryIataCode);
    }

    @GetMapping("/cities")
    @Operation(summary = "Consulta cidades principais com aeroportos")
    public List<AirportCity> findAirportCity() throws JsonProcessingException {
        return airportTimeTableService.findAirportCity();
    }

    @GetMapping("/countries")
    @Operation(summary = "Consulta codigos iata dos países")
    public List<AirportCountry> findAirportsByCountry() throws JsonProcessingException {
        return airportTimeTableService.findAIataCodeByCountry();
    }

    @PostMapping("/flight-status")
    @Operation(summary = "Consulta status dos voos com filtros")
    public FlighData findFlighsStatus(@RequestBody FlighStatusFilter filter) {
        return flightInfoService.findFlightsStatus(filter);
    }

    @PostMapping("/fligh-schedules")
    @Operation(summary = "Consulta agendamento de voos com filtros")
    public FlighData findFlightsSchedules(@RequestBody FlighStatusFilter filter) {
        return flightInfoService.findFlightsSchedules(filter);
    }

}
