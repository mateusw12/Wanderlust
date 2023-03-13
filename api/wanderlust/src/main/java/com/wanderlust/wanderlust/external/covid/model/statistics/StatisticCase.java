package com.wanderlust.wanderlust.external.covid.model.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatisticCase {

    @JsonProperty("1M_pop")
    private String pop1Mi;

    private Long active;

    private Long critical;

    @JsonProperty("new")
    private String novos;

    private Long recovered;

    private Long total;

}
