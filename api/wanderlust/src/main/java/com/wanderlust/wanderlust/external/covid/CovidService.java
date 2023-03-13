package com.wanderlust.wanderlust.external.covid;

import com.wanderlust.wanderlust.external.covid.model.statistics.CovidStatistics;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CovidService {

    private final String apiKey = "";

    public CovidStatistics findStatisticsCountry(String country) {
        String apiUrl = "https://covid-193.p.rapidapi.com/statistics";
        String countryFormat = country.replace(" ", "%20");

        if(country.length() > 0){
            apiUrl = apiUrl+"?country="+countryFormat;
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "covid-193.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CovidStatistics> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                CovidStatistics.class
        );
        CovidStatistics covidStatistics = response.getBody();
        return covidStatistics;
    }

    public CovidStatistics findStatistics() {
        String apiUrl = "https://covid-193.p.rapidapi.com/statistics";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "covid-193.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CovidStatistics> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                CovidStatistics.class
        );
        CovidStatistics covidStatistics = response.getBody();
        return covidStatistics;
    }

}
