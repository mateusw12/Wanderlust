package com.wanderlust.wanderlust.external.covid.model.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatisticTests {

    @JsonProperty("1M_pop")
    private String popMi;

    private Long total;

}
