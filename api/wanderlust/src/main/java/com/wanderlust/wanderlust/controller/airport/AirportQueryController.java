package com.wanderlust.wanderlust.controller.airport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wanderlust.wanderlust.external.airportAndFlight.aeroDataBox.AeroDataBoxService;
import com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.BrazilianArlineDataService;
import com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.model.BrazilianAirlineDataFilter;
import com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.model.BrazilianArilineData;
import com.wanderlust.wanderlust.external.airportAndFlight.model.aiportInfo.Airport;
import com.wanderlust.wanderlust.external.airportAndFlight.model.aiportRoutesDailyFlight.AiportRoutesDailyFlight;
import com.wanderlust.wanderlust.external.airportAndFlight.model.airportSearchResult.AirportSearchResult;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.AirportTimeTableService;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airportCity.AirportCity;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airportCountry.AirportCountry;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airports.AirportTimeTable;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.country.AirportResponse;
import com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.FlightInfoService;
import com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status.FlighData;
import com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.filter.FlighStatusFilter;
import com.wanderlust.wanderlust.external.airportAndFlight.ryanair.RyanairService;
import com.wanderlust.wanderlust.external.airportAndFlight.ryanair.model.RyanairAirportInfo;
import com.wanderlust.wanderlust.external.airportAndFlight.ryanair.model.RyanairAirportRoutes;
import com.wanderlust.wanderlust.external.airportAndFlight.skyscanner.SkyscannerService;
import com.wanderlust.wanderlust.external.airportAndFlight.skyscanner.model.SkyscannerSearchAirport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/consulta-aeroporto")
@Tag(name = "Consulta de aeroportos")
public class AirportQueryController {

    @Autowired
    private AeroDataBoxService aeroDataBoxService;

    @Autowired
    private FlightInfoService flightInfoService;

    @Autowired
    private AirportTimeTableService airportTimeTableService;

    @Autowired
    private RyanairService ryanairService;

    @Autowired
    private SkyscannerService skyscannerService;

    @Autowired
    private BrazilianArlineDataService brazilianArlineDataService;

    @GetMapping("/aero-data/info/{airportDataCode}")
    @Operation(summary = "Consulta informação do aeroporto pela IATA")
    public Airport findAirportByIataCode(@PathVariable @NotNull @NotBlank String airportDataCode) {
        return aeroDataBoxService.findAirportByIataCode(airportDataCode);
    }

    @GetMapping("/aero-data/search/{airportName}")
    @Operation(summary = "Consulta informação do aeroporto pelo nome")
    public AirportSearchResult findAirportBySearchName(@PathVariable @NotNull @NotBlank String airportName) {
        return aeroDataBoxService.findAirportBySearchName(airportName);
    }

    @GetMapping("/aero-data/routes/{airportIcaoCode}")
    @Operation(summary = "Consulta rotas de voos do aeroporto pelo ICAO")
    public AiportRoutesDailyFlight findAirportRoutes(@PathVariable @NotNull @NotBlank String airportIcaoCode) {
        return aeroDataBoxService.findAirportRoutes(airportIcaoCode);
    }

    @GetMapping("/airport-time")
    @Operation(summary = "Consulta todos os aeroportos")
    public List<AirportTimeTable> findAirports() throws JsonProcessingException {
        return airportTimeTableService.findAirports();
    }

    @GetMapping("/airport-time/country/{countryIataCode}")
    @Operation(summary = "Consulta todos os aeroportos")
    public AirportResponse findAirports(@PathVariable @NotNull @NotBlank String countryIataCode) throws JsonProcessingException {
        return airportTimeTableService.findAirportsByCountry(countryIataCode);
    }

    @GetMapping("/airport-time/cities")
    @Operation(summary = "Consulta cidades principais com aeroportos")
    public List<AirportCity> findAirportCity() throws JsonProcessingException {
        return airportTimeTableService.findAirportCity();
    }

    @GetMapping("/airport-time/countries")
    @Operation(summary = "Consulta codigos iata dos países")
    public List<AirportCountry> findAirportsByCountry() throws JsonProcessingException {
        return airportTimeTableService.findAIataCodeByCountry();
    }

    @GetMapping("/ryanair/airports")
    @Operation(summary = "Consulta aeroportos da rayanair")
    public List<RyanairAirportInfo> findRyanairAirports() {
        return ryanairService.findAirports();
    }

    @GetMapping("/ryanair/routes/{originIataCode}")
    @Operation(summary = "Consulta rotas da rayanair")
    public List<RyanairAirportRoutes> findRyanairAirports(@PathVariable @NotNull @NotBlank String originIataCode) {
        return ryanairService.findRoutes(originIataCode);
    }

    @PostMapping("/flight-info/status")
    @Operation(summary = "Consulta status dos voos com filtros")
    public FlighData findFlighsStatus(@RequestBody @Valid FlighStatusFilter filter) {
        return flightInfoService.findFlightsStatus(filter);
    }

    @PostMapping("/flight-info/schedules")
    @Operation(summary = "Consulta agendamento de voos com filtros")
    public FlighData findFlightsSchedules(@RequestBody @Valid FlighStatusFilter filter) {
        return flightInfoService.findFlightsSchedules(filter);
    }

    @GetMapping("/skyscanner/search-airport/{cityName}")
    @Operation(summary = "Consulta aeroportos por cidade")
    public SkyscannerSearchAirport findSearchAirport(@PathVariable @NotNull @NotBlank String cityName) {
        return skyscannerService.findSearchAirport(cityName);
    }

    @PostMapping("/brazilian-airline/search-airline")
    @Operation(summary = "Consulta voos por companhia aerea do brasil")
    public List<BrazilianArilineData> findSearchAirport(@RequestBody @Valid BrazilianAirlineDataFilter filter) {
        return brazilianArlineDataService.findAirlineData(filter);
    }

}
