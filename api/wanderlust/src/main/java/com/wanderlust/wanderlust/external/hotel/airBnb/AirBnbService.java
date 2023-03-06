package com.wanderlust.wanderlust.external.hotel.airBnb;

import com.wanderlust.wanderlust.external.hotel.airBnb.model.category.AirBnbCategory;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.destination.AirBnbLocation;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.AirBnbPropertyFilter;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.AirBnbPropertyLocation;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace.AirBnbPropertyLocationPlace;
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

    public AirBnbPropertyLocation findSearchProperty(AirBnbPropertyFilter filter) {
        String apiUrl = "https://airbnb19.p.rapidapi.com/api/v1/searchProperty?";

        if(filter.getCategory() != null){
            apiUrl = apiUrl+"category="+filter.getCategory();
            apiUrl = apiUrl+"totalRecords=10";
        }

        if(filter.getCurrency() != null){
            apiUrl = apiUrl+"&currency="+filter.getCurrency();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getChildren() >0){
            apiUrl = apiUrl+"&children="+filter.getChildren();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getInfants() >0){
            apiUrl = apiUrl+"&infants="+filter.getInfants();
        }

        if(filter.getPets() >0){
            apiUrl = apiUrl+"&pets="+filter.getPets();
        }


        if(filter.getCheckin() != null){
            apiUrl = apiUrl+"&checkin="+filter.getCheckin();
        }

        if(filter.getCheckout() != null){
            apiUrl = apiUrl+"&checkout="+filter.getPets();
        }

        if(filter.getPriceMin() >0){
            apiUrl = apiUrl+"&priceMin="+filter.getPriceMin();
        }

        if(filter.getPriceMax() >0){
            apiUrl = apiUrl+"&priceMax="+filter.getPriceMax();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "airbnb19.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AirBnbPropertyLocation> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                AirBnbPropertyLocation.class
        );
        AirBnbPropertyLocation airBnbPropertyLocation = response.getBody();
        return airBnbPropertyLocation;
    }

    public AirBnbPropertyLocationPlace findSearchPropertyPlace(AirBnbPropertyFilter filter) {
        String apiUrl = "https://airbnb19.p.rapidapi.com/api/v1/searchPropertyByPlace?";

        if(filter.getCategory() != null){
            apiUrl = apiUrl+"category="+filter.getCategory();
            apiUrl = apiUrl+"totalRecords=10";
        }

        if(filter.getCurrency() != null){
            apiUrl = apiUrl+"&currency="+filter.getCurrency();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getChildren() >0){
            apiUrl = apiUrl+"&children="+filter.getChildren();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getAdults() >0){
            apiUrl = apiUrl+"&adults="+filter.getAdults();
        }

        if(filter.getInfants() >0){
            apiUrl = apiUrl+"&infants="+filter.getInfants();
        }

        if(filter.getPets() >0){
            apiUrl = apiUrl+"&pets="+filter.getPets();
        }


        if(filter.getCheckin() != null){
            apiUrl = apiUrl+"&checkin="+filter.getCheckin();
        }

        if(filter.getCheckout() != null){
            apiUrl = apiUrl+"&checkout="+filter.getPets();
        }

        if(filter.getPriceMin() >0){
            apiUrl = apiUrl+"&priceMin="+filter.getPriceMin();
        }

        if(filter.getPriceMax() >0){
            apiUrl = apiUrl+"&priceMax="+filter.getPriceMax();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "airbnb19.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AirBnbPropertyLocationPlace> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                AirBnbPropertyLocationPlace.class
        );
        AirBnbPropertyLocationPlace airBnbPropertyLocation = response.getBody();
        return airBnbPropertyLocation;
    }

    public AirBnbCategory findCategory() {
        String apiUrl = "https://airbnb19.p.rapidapi.com/api/v1/getCategory";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "airbnb19.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<AirBnbCategory> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                AirBnbCategory.class
        );
        AirBnbCategory airBnbCategory = response.getBody();
        return airBnbCategory;
    }

}
