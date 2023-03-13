package com.wanderlust.wanderlust.external.covid.model.statistics;

import lombok.Data;

import java.util.List;

@Data
public class CovidStatistics {

    private String get;
    private List<StatisticResponse> response;

}
