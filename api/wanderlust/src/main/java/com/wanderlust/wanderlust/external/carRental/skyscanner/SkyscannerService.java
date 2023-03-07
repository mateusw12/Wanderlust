package com.wanderlust.wanderlust.external.carRental.skyscanner;

import com.wanderlust.wanderlust.external.carRental.carData.model.CarData;
import com.wanderlust.wanderlust.external.carRental.carData.model.CarDataFilter;
import com.wanderlust.wanderlust.external.carRental.skyscanner.model.SkyscannerSearchLocation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SkyscannerService {

    private final String apiKey = "d5075a53bemshe3df1656b7affc0p136397jsnf9c8d0f8ddbc";

    public SkyscannerSearchLocation findSearchLocationCar(String cityName) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://skyscanner50.p.rapidapi.com/api/v1/searchLocation?query="+cityNameFormat;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "skyscanner50.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<SkyscannerSearchLocation> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                SkyscannerSearchLocation.class
        );
        SkyscannerSearchLocation skyscannerSearchLocation = response.getBody();
        return skyscannerSearchLocation;
    }

}
