package com.wanderlust.wanderlust.external.weatherForecast.model.forecast;

import com.wanderlust.wanderlust.external.weatherForecast.model.currentWeatherForecast.CurrentCondition;
import lombok.Data;

@Data
public class Day {

    private Double maxtemp_c;
    private Double maxtemp_f;
    private Double mintemp_c;
    private Double mintemp_f;
    private Double avgtemp_c;
    private Double avgtemp_f;
    private Double maxwind_mph;
    private Double maxwind_kph;
    private Double totalprecip_mm;
    private Double totalprecip_in;
    private Double totalsnow_cm;
    private Double avgvis_km;
    private Double avgvis_miles;
    private Double avghumidity;
    private Double daily_will_it_rain;
    private Double daily_chance_of_rain;
    private Double daily_will_it_snow;
    private Double daily_chance_of_snow;
    private CurrentCondition conditionDay;
    private Double uv;
}
