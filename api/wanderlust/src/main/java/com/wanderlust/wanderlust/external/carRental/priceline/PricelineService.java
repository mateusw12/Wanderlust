package com.wanderlust.wanderlust.external.carRental.priceline;

import com.wanderlust.wanderlust.external.carRental.priceline.model.searchCars.PricelineSearchCars;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PricelineService {

    private final String apiKey = "d5075a53bemshe3df1656b7affc0p136397jsnf9c8d0f8ddbc";

    public List<PricelineSearchCars> findSearchLocationCars(String cityName) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://priceline-com-provider.p.rapidapi.com/v1/cars-rentals/locations?name="+cityNameFormat;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "priceline-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<PricelineSearchCars>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<PricelineSearchCars>>() {}
        );
        List<PricelineSearchCars> pricelineSearchCars = response.getBody();
        return pricelineSearchCars;
    }

}
