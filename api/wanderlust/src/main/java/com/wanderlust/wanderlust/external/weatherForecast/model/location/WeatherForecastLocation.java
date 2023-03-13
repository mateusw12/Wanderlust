package com.wanderlust.wanderlust.external.weatherForecast.model.location;

import lombok.Data;

import java.util.Date;

@Data
public class WeatherForecastLocation {

    private String name;
    private String region;
    private String city;
    private String country;
    private Double lat;
    private Double lon;
    private String tz_id;
    private Double localtime_epoch;
    private Date localtime;

}
