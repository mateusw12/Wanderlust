package com.wanderlust.wanderlust.external.tranfer.taxiFare.model;

import lombok.Data;

import java.util.List;

@Data
public class TaxiFareJourney {

    private String city_name;
    private String department;
    private String arrival;
    private Double duration;
    private Double distance;
    private List<Fares> fares;

}
