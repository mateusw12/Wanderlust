package com.wanderlust.wanderlust.external.tranfer.taxiFare;

import com.wanderlust.wanderlust.external.tranfer.taxiFare.model.TaxiFare;
import com.wanderlust.wanderlust.external.tranfer.taxiFare.model.filter.TaxiFareFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaxiFareService {

    private final String apiKey = "";

    public TaxiFare findTaxiFare(TaxiFareFilter filter) {
        String apiUrl = "https://taxi-fare-calculator.p.rapidapi.com/search-geo?";

        if(filter.getDepeartureLat() != null){
            apiUrl = apiUrl + "dep_lat="+filter.getDepeartureLat();
        }

        if(filter.getDepeartureLon() != null){
            apiUrl = apiUrl + "&dep_lng="+filter.getDepeartureLon();
        }

        if(filter.getArriveLat() != null){
            apiUrl = apiUrl + "&arr_lat="+filter.getArriveLat();
        }

        if(filter.getArriveLon() != null){
            apiUrl = apiUrl + "&arr_lng="+filter.getArriveLon();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "taxi-fare-calculator.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TaxiFare> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                TaxiFare.class
        );
        TaxiFare taxiFare = response.getBody();
        return taxiFare;
    }

}
