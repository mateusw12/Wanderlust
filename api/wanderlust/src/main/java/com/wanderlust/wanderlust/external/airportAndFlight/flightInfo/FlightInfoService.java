package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo;

import com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.filter.FlighStatusFilter;
import com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status.FlighData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightInfoService {

    private final String apiKey ="5e6bae4b07mshe77f32ea846bc94p149ec3jsn926370fa091c";

    public FlighData findFlightsStatus(FlighStatusFilter filter) {
        String apiUrl = "https://flight-info-api.p.rapidapi.com/status?version=v1";

        if(filter.getEndDate() != null){
          apiUrl = apiUrl + "&DepartureDate="+filter.getEndDate()+"";
        }
        if (filter.getStartDate() != null){
            apiUrl = apiUrl + "&ArrivalDate="+filter.getStartDate()+"";
        }
        if (filter.getStartAirport() != null){
            apiUrl = apiUrl + "&ArrivalAirport="+filter.getStartAirport()+"";
        }
        if (filter.getEndAirport() != null){
            apiUrl = apiUrl + "&DepartureAirport="+filter.getEndAirport()+"";
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "flight-info-api.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<FlighData> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, FlighData.class);
        FlighData flighData = response.getBody();
        return flighData;
    }

    public FlighData findFlightsSchedules(FlighStatusFilter filter) {
        String apiUrl = "https://flight-info-api.p.rapidapi.com/schedules?version=v1";

        if(filter.getEndDate() != null){
            apiUrl = apiUrl + "&DepartureDate="+filter.getEndDate()+"";
        }
        if (filter.getStartDate() != null){
            apiUrl = apiUrl + "&ArrivalDate="+filter.getStartDate()+"";
        }
        if (filter.getStartAirport() != null){
            apiUrl = apiUrl + "&ArrivalAirport="+filter.getStartAirport()+"";
        }
        if (filter.getEndAirport() != null){
            apiUrl = apiUrl + "&DepartureAirport="+filter.getEndAirport()+"";
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "flight-info-api.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<FlighData> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, FlighData.class);
        FlighData flighData = response.getBody();
        return flighData;
    }


}
