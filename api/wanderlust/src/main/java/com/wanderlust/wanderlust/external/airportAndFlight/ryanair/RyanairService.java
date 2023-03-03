package com.wanderlust.wanderlust.external.airportAndFlight.ryanair;

import com.wanderlust.wanderlust.external.airportAndFlight.ryanair.model.RyanairAirportInfo;
import com.wanderlust.wanderlust.external.airportAndFlight.ryanair.model.RyanairAirportRoutes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RyanairService {

    private final String apiKey = "5e6bae4b07mshe77f32ea846bc94p149ec3jsn926370fa091c";

    public List<RyanairAirportInfo> findAirports() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "ryanair.p.rapidapi.com");

        String apiUrl = "https://ryanair.p.rapidapi.com/airports";

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<RyanairAirportInfo>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<RyanairAirportInfo>>() {}
        );
        List<RyanairAirportInfo> airports = response.getBody();
        return airports;
    }

    public List<RyanairAirportRoutes> findRoutes(String originIataAirportCode) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "ryanair.p.rapidapi.com");

        String apiUrl = "https://ryanair.p.rapidapi.com/routes?origin_code="+originIataAirportCode+"";

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<RyanairAirportRoutes>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<RyanairAirportRoutes>>() {}
        );
        List<RyanairAirportRoutes> airports = response.getBody();
        return airports;
    }

}
