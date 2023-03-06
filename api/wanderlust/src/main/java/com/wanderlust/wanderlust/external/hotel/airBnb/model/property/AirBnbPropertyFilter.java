package com.wanderlust.wanderlust.external.hotel.airBnb.model.property;

import lombok.Data;

import java.util.Date;

@Data
public class AirBnbPropertyFilter {

    private String category;
    private String currency;
    private Long adults;
    private Long children;
    private Long infants;
    private Long pets;
    private Date checkin;
    private Date checkout;
    private Double priceMin;
    private Double priceMax;

}
