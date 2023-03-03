package com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airportCity.AirportCity;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airportCountry.AirportCountry;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.airports.AirportTimeTable;
import com.wanderlust.wanderlust.external.airportAndFlight.airportTimeTable.model.country.AirportResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

@Service
public class AirportTimeTableService {

    private final String apiKey ="5e6bae4b07mshe77f32ea846bc94p149ec3jsn926370fa091c";

    public List<AirportTimeTable> findAirports() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "timetable-lookup.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://timetable-lookup.p.rapidapi.com/airports/";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String xmlString = response.getBody();
        ObjectMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        JsonNode jsonNode = jsonMapper.readTree(jsonMapper.writeValueAsString(xmlMapper.readTree(xmlString)));

        List<AirportTimeTable> airports = jsonMapper.readValue(jsonNode.get("Airport").toString(), new TypeReference<List<AirportTimeTable>>() {});
        return airports;
    }

    public AirportResponse findAirportsByCountry(String CountryIataCode) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "timetable-lookup.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://timetable-lookup.p.rapidapi.com/airports/countries/"+CountryIataCode+"/";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String xmlString = response.getBody();
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        JsonNode jsonNode = jsonMapper.readTree(jsonMapper.writeValueAsString(xmlMapper.readTree(xmlString)));

        AirportResponse airports = jsonMapper.readValue(jsonNode.toString(), new TypeReference<AirportResponse>() {});
        return airports;
    }

    public List<AirportCity> findAirportCity() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "timetable-lookup.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://timetable-lookup.p.rapidapi.com/airports/metros/";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String xmlString = response.getBody();
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        JsonNode jsonNode = jsonMapper.readTree(jsonMapper.writeValueAsString(xmlMapper.readTree(xmlString).get("Metro")));

        List<AirportCity> airportCity = jsonMapper.readValue(jsonNode.toString(), new TypeReference<List<AirportCity>>() {});
        return airportCity;
    }

    public List<AirportCountry> findAIataCodeByCountry() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "timetable-lookup.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://timetable-lookup.p.rapidapi.com/airports/countries/";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String xmlString = response.getBody();
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();

        JsonNode jsonNode = jsonMapper.readTree(jsonMapper.writeValueAsString(xmlMapper.readTree(xmlString).get("Country")));

        List<AirportCountry> airportCountries = jsonMapper.readValue(jsonNode.toString(), new TypeReference<List<AirportCountry>>() {});
        return airportCountries;
    }

}
