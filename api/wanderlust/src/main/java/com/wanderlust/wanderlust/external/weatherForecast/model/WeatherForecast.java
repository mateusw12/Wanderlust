package com.wanderlust.wanderlust.external.weatherForecast.model;

import com.wanderlust.wanderlust.external.weatherForecast.model.currentWeatherForecast.WeatherForecastCurrent;
import com.wanderlust.wanderlust.external.weatherForecast.model.forecast.Forecast;
import com.wanderlust.wanderlust.external.weatherForecast.model.location.WeatherForecastLocation;
import lombok.Data;

@Data
public class WeatherForecast {

    private WeatherForecastLocation location;
    private WeatherForecastCurrent current;
    private Forecast forecast;

}
