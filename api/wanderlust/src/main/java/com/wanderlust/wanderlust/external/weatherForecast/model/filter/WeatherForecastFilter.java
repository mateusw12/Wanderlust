package com.wanderlust.wanderlust.external.weatherForecast.model.filter;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
public class WeatherForecastFilter {

    @NotNull
    @NotBlank
    private String City;

    @NotNull
    @Positive
    private Long days;

    private Date date;

}
