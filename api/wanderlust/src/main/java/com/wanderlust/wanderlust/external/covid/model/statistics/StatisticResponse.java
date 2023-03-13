package com.wanderlust.wanderlust.external.covid.model.statistics;

import lombok.Data;

import java.util.Date;

@Data
public class StatisticResponse {

    private String continent;
    private String country;
    private Date day;
    private Long population;
    private Date time;
    private StatisticCase cases;
    private StatisticDeaths deaths;
    private StatisticTests tests;

}
