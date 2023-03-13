package com.wanderlust.wanderlust.external.weatherForecast.model.forecast;

import lombok.Data;

import java.util.List;

@Data
public class Forecast {

    private List<ForecastDay> forecastday;

}
