package com.wanderlust.wanderlust.external.hotel.hotelProvider;

import com.wanderlust.wanderlust.external.hotel.booking.model.data.BookingHotel;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.region.RegionSearch;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelProviderService {

    private final String apiKey = "d5075a53bemshe3df1656b7affc0p136397jsnf9c8d0f8ddbc";

    public RegionSearch findRegionSearch(String cityName, String Country) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://hotels-com-provider.p.rapidapi.com/v2/regions?locale=pt_BR&query="+cityNameFormat+"&domain="+Country;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "hotels-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<RegionSearch> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                RegionSearch.class
        );
        RegionSearch regionSearch = response.getBody();
        return regionSearch;
    }

}
