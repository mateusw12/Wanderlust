package com.wanderlust.wanderlust.external.weatherForecast.model.currentWeatherForecast;

import lombok.Data;

@Data
public class CurrentCondition {

    private String text;
    private String icon;
    private Long code;

}
