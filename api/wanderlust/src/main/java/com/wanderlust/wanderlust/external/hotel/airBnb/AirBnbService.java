package com.wanderlust.wanderlust.external.hotel.airBnb;

import com.wanderlust.wanderlust.external.hotel.airBnb.model.destination.AirBnbLocation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirBnbService {

    private final String apiKey = "5e6bae4b07mshe77f32ea846bc94p149ec3jsn926370fa091c";

    public AirBnbLocation findSearchDestination(String cityName, String country) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://airbnb19.p.rapidapi.com/api/v1/searchDestination?query="+cityNameFormat;

        if(country.length() >0 ){
            apiUrl = apiUrl+"&country="+country;
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "airbnb19.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AirBnbLocation> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                AirBnbLocation.class
        );
        AirBnbLocation airBnbLocation = response.getBody();
        return airBnbLocation;
    }

}
