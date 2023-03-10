package com.wanderlust.wanderlust.external.tranfer.waze;

import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.PricelineHotelDetail;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.WazeAlertAndJams;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.WazeAlertAndJamsFilter;
import com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection.WazeDrivingDirection;
import com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection.WazeDrivingDirectionFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WazeService {

    private final String apiKey="";

    public WazeAlertAndJams findAlertAndJams(WazeAlertAndJamsFilter filter) {
        String apiUrl = "https://waze.p.rapidapi.com/alerts-and-jams?";

        if(filter.getBottom_left() != null){
            apiUrl = apiUrl + "bottom_left="+filter.getBottom_left();
        }

        if(filter.getTop_right() != null){
            apiUrl = apiUrl + "&top_right="+filter.getTop_right();
        }

        apiUrl = apiUrl +"&max_alerts=20&max_jams=20";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "waze.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<WazeAlertAndJams> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                WazeAlertAndJams.class
        );
        WazeAlertAndJams wazeAlertAndJams = response.getBody();
        return wazeAlertAndJams;
    }

    public WazeDrivingDirection findDrivingDirections(WazeDrivingDirectionFilter filter) {
        String apiUrl = "https://waze.p.rapidapi.com/driving-directions?";

        if(filter.getSource_coordinates() != null){
            apiUrl = apiUrl + "source_coordinates="+filter.getSource_coordinates();
        }

        if(filter.getDestination_coordinates() != null){
            apiUrl = apiUrl + "&destination_coordinates="+filter.getDestination_coordinates();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "waze.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<WazeDrivingDirection> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                WazeDrivingDirection.class
        );
        WazeDrivingDirection wazeDrivingDirection = response.getBody();
        return wazeDrivingDirection;
    }

}
