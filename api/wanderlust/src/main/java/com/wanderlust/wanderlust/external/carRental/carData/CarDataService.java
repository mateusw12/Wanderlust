package com.wanderlust.wanderlust.external.carRental.carData;

import com.wanderlust.wanderlust.external.carRental.booking.model.BookingRentalCar;
import com.wanderlust.wanderlust.external.carRental.carData.model.CarData;
import com.wanderlust.wanderlust.external.carRental.carData.model.CarDataFilter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CarDataService {

    private final String apiKey = "";

    public List<CarData> findCarsByFilter(CarDataFilter filter) {
        String apiUrl = "https://car-data.p.rapidapi.com/cars?limit=50&page=0";

        if(filter.getMake() != null){
            apiUrl = apiUrl + "&make="+filter.getMake().getDescription();
        }

        if(filter.getType() != null){
            apiUrl = apiUrl + "&type="+filter.getType().getDescription();
        }

        if(filter.getYear() != null){
            apiUrl = apiUrl + "&year="+filter.getYear().getDescription();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "car-data.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<CarData>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<CarData>>() {}
        );
        List<CarData> carData = response.getBody();
        return carData;
    }

}
