package com.wanderlust.wanderlust.external.hotel.priceline;

import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.PricelineHotelDetail;
import com.wanderlust.wanderlust.external.hotel.priceline.model.searchLocation.PricelineSearchHotelLocation;
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

    public List<PricelineSearchHotelLocation> findSearcHotelsLocations(String cityName, String searchType) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://priceline-com-provider.p.rapidapi.com/v1/hotels/locations?name="+cityNameFormat+"&search_type="+searchType;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "priceline-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<PricelineSearchHotelLocation>> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<PricelineSearchHotelLocation>>() {}
        );
        List<PricelineSearchHotelLocation> pricelineSearchHotelLocations = response.getBody();
        return pricelineSearchHotelLocations;
    }

    public PricelineHotelDetail findHotelDetailByHotelId(Long hotelId) {
        String apiUrl = "https://priceline-com-provider.p.rapidapi.com/v1/hotels/details?hotel_id="+hotelId;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "priceline-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PricelineHotelDetail> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                PricelineHotelDetail.class
        );
        PricelineHotelDetail pricelineHotelDetail = response.getBody();
        return pricelineHotelDetail;
    }

}
