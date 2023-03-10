package com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData;

import com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.model.BrazilianAirlineDataFilter;
import com.wanderlust.wanderlust.external.airportAndFlight.brazilianAirlineData.model.BrazilianArilineData;
import com.wanderlust.wanderlust.external.carRental.skyscanner.model.SkyscannerSearchLocation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BrazilianArlineDataService {

    private final String apiKey = "";

    public List<BrazilianArilineData> findAirlineData(BrazilianAirlineDataFilter filter) {
        String apiUrl = "https://brazilian-airlines-real-flights-data.p.rapidapi.com/flights?";

        if(filter.getCompany() != null){
            apiUrl = apiUrl + "company="+filter.getCompany();
        }

        if(filter.getDate() != null){
            apiUrl = apiUrl + "&date="+filter.getDate();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "brazilian-airlines-real-flights-data.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<BrazilianArilineData>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BrazilianArilineData>>() {}
        );
        List<BrazilianArilineData> brazilianArilineDataList = response.getBody();
        return brazilianArilineDataList;
    }

}
