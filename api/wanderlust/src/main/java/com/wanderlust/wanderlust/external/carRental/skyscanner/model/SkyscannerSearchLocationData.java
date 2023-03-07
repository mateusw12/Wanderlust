package com.wanderlust.wanderlust.external.carRental.skyscanner.model;

import lombok.Data;

@Data
public class SkyscannerSearchLocationData {

    private String hierarchy;
    private String location;
    private String entity_name;
    private String entity_id;
    private SkyscannerSearchLocationHighlight highlight;

}
