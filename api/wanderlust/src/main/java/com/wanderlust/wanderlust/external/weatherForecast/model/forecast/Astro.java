package com.wanderlust.wanderlust.external.weatherForecast.model.forecast;

import lombok.Data;

@Data
public class Astro {

    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private String moon_phase;
    private String moon_illumination;
    private Boolean is_moon_up;
    private Boolean is_sun_up;

}
