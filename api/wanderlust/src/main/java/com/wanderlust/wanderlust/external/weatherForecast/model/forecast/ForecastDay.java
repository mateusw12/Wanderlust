package com.wanderlust.wanderlust.external.weatherForecast.model.forecast;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ForecastDay {

    private Date date;
    private Long date_epoch;
    private Day day;
    private Astro astro;
    private List<Hour> hour;

}
