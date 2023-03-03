package com.wanderlust.wanderlust.external.airportAndFlight.aeroDataBox;

import com.wanderlust.wanderlust.external.airportAndFlight.model.aiportRoutesDailyFlight.AiportRoutesDailyFlight;
import com.wanderlust.wanderlust.external.airportAndFlight.model.aiportInfo.Airport;
import com.wanderlust.wanderlust.external.airportAndFlight.model.airportSearchResult.AirportSearchResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class AeroDataBoxService {

    private final String apiKey = "5e6bae4b07mshe77f32ea846bc94p149ec3jsn926370fa091c";

    public Airport findAirportByIataCode(String airportDataCode) {
        String codeType = "iata";
        String apiUrl = "https://aerodatabox.p.rapidapi.com/airports/"+codeType+"/"+airportDataCode+"";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "aerodatabox.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Airport> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Airport.class);
        Airport airport = response.getBody();
        return airport;
    }

    public AirportSearchResult findAirportBySearchName(String airportName) {
        String apiUrl = "https://aerodatabox.p.rapidapi.com/airports/search/term?q="+airportName+"&limit=10";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "aerodatabox.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AirportSearchResult> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, AirportSearchResult.class);
        AirportSearchResult airportSearchResult = response.getBody();
        return airportSearchResult;
    }

    public AiportRoutesDailyFlight findAirportRoutes(String airportIcaoCode) {
        String apiUrl = "https://aerodatabox.p.rapidapi.com/airports/icao/"+airportIcaoCode+"/stats/routes/daily";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "aerodatabox.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AiportRoutesDailyFlight> response;
        response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, AiportRoutesDailyFlight.class);
        AiportRoutesDailyFlight aiportRoutesDailyFlights = response.getBody();
        return aiportRoutesDailyFlights;
    }

}
