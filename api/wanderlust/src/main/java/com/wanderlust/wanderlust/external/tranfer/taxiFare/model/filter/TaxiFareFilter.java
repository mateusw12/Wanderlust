package com.wanderlust.wanderlust.external.tranfer.taxiFare.model.filter;

import lombok.Data;

@Data
public class TaxiFareFilter {

    private Double depeartureLat;
    private Double depeartureLon;
    private Double arriveLat;
    private Double arriveLon;

}
