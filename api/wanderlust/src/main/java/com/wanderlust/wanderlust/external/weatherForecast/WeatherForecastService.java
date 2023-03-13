package com.wanderlust.wanderlust.external.weatherForecast;

import com.wanderlust.wanderlust.external.weatherForecast.model.WeatherForecast;
import com.wanderlust.wanderlust.external.weatherForecast.model.filter.WeatherForecastFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherForecastService {

    private final String apiKey = "";

    public WeatherForecast forecast(WeatherForecastFilter filter) {
        String apiUrl = "https://weatherapi-com.p.rapidapi.com/forecast.json?&lang=pt";

        if(filter.getCity() != null){
            apiUrl = apiUrl + "q="+filter.getCity();
        }

        if(filter.getDays() != null){
            apiUrl = apiUrl + "&&days="+filter.getDays();
        }

        apiUrl = apiUrl + "&lang=pt";

        if(filter.getDate() != null){
            apiUrl = apiUrl + "&dt="+filter.getDate();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<WeatherForecast> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                WeatherForecast.class
        );
        WeatherForecast weatherForecast = response.getBody();
        return weatherForecast;
    }

}
