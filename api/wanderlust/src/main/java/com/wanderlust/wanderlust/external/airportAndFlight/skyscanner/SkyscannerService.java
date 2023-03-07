package com.wanderlust.wanderlust.external.airportAndFlight.skyscanner;

import com.wanderlust.wanderlust.external.airportAndFlight.ryanair.model.RyanairAirportInfo;
import com.wanderlust.wanderlust.external.airportAndFlight.skyscanner.model.SkyscannerSearchAirport;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SkyscannerService {

    private final String apiKey = "d5075a53bemshe3df1656b7affc0p136397jsnf9c8d0f8ddbc";

    public SkyscannerSearchAirport findSearchAirport(String cityName) {
        String cityNameFormat = cityName.replace(" ", "%20");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "skyscanner50.p.rapidapi.com");

        String apiUrl = "https://skyscanner50.p.rapidapi.com/api/v1/searchAirport?query="+cityNameFormat;

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<SkyscannerSearchAirport> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                SkyscannerSearchAirport.class
        );
        SkyscannerSearchAirport searchAirport = response.getBody();
        return searchAirport;
    }

}
