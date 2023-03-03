package com.wanderlust.wanderlust.external.carRental.carData.model;

import lombok.Data;

@Data
public class CarDataFilter {

    private Type type;
    private Make make;
    private Year year;

}
