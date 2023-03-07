package com.wanderlust.wanderlust.external.carRental.skyscanner.model;

import lombok.Data;

import java.util.List;

@Data
public class SkyscannerSearchLocation {

    private String status;
    private String message;
    private List<SkyscannerSearchLocationData> data;

}
