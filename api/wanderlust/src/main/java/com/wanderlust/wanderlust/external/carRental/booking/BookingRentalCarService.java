package com.wanderlust.wanderlust.external.carRental.booking;

import com.wanderlust.wanderlust.external.carRental.booking.model.BookingRentalCar;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingRentalCarService {

    private final String apiKey = "";

    public List<BookingRentalCar> findRentalCarByCityName(String cityName) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/car-rental/locations?name="+cityNameFormat+"&locale=pt-br";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<BookingRentalCar>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BookingRentalCar>>() {}
        );
        List<BookingRentalCar> bookingRentalCars = response.getBody();
        return bookingRentalCars;
    }
}
