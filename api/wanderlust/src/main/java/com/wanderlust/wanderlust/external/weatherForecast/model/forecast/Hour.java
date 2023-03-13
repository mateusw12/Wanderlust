package com.wanderlust.wanderlust.external.weatherForecast.model.forecast;

import com.wanderlust.wanderlust.external.weatherForecast.model.currentWeatherForecast.CurrentCondition;
import lombok.Data;

import java.util.Date;

@Data
public class Hour {

    private Long time_epoch;
    private Date time;
    private Double temp_c;
    private Double temp_f;
    private Boolean is_day;
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
    private Double feelslike_c;
    private Double feelslike_f;
    private Double windchill_c;
    private Double windchill_f;
    private Double heatindex_c;
    private Double heatindex_f;
    private Double dewpoint_c;
    private Double dewpoint_f;
    private Double will_it_rain;
    private Double chance_of_rain;
    private Double will_it_snow;
    private Double chance_of_snow;
    private Double vis_km;
    private Double vis_miles;
    private Double gust_mph;
    private Double gust_kph;
    private Double uv;

}
