package com.wanderlust.wanderlust.external.hotel.airBnb.model.destination;

import lombok.Data;

import java.util.List;

@Data
public class AirBnbData {

    private String id;
    private String location_name;
    private List<AirBnbTerms> terms;
    private String country_code;
    private String countryCode;
    private String display_name;

}
