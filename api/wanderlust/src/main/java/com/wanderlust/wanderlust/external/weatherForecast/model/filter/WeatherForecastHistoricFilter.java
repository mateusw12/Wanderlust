package com.wanderlust.wanderlust.external.weatherForecast.model.filter;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class WeatherForecastHistoricFilter {

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    private Date date;

    @NotNull
    private Date endDate;


}
