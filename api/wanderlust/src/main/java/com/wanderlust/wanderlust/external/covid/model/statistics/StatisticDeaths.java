package com.wanderlust.wanderlust.external.covid.model.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatisticDeaths {

    @JsonProperty("1M_pop")
    private String pop1Mi;

    @JsonProperty("new")
    private String novos;

    private Long total;

}
