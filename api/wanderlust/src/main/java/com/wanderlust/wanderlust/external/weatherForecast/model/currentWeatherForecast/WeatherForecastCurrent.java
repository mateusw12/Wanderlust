package com.wanderlust.wanderlust.external.weatherForecast.model.currentWeatherForecast;

import com.wanderlust.wanderlust.external.weatherForecast.model.currentWeatherForecast.CurrentCondition;
import lombok.Data;

import java.util.Date;

@Data
public class WeatherForecastCurrent {

    private Long last_updated_epoch;
    private Date last_updated;
    private Double temp_c;
    private Double temp_f;
    private Long is_day;
    private CurrentCondition condition;
    private Double wind_mph;
    private Double wind_kph;
    private Double wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private Double pressure_in;
    private Double precip_mm;
    private Double precip_in;
    private Double humidity;
    private Double cloud;
    private Double feelslike_f;
    private Double feelslike_c;
    private Double vis_km;
    private Double vis_miles;
    private Double uv;
    private Double gust_mph;
    private Double gust_kph;

}
