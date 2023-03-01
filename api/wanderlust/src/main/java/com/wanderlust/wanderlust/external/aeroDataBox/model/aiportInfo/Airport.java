package com.wanderlust.wanderlust.external.aeroDataBox.model.aiportInfo;

import lombok.Data;

@Data
public class Airport {

    private String icao;
    private String iata;
    private String localCode;
    private String shortName;
    private String fullName;
    private String municipalityName;
    private Location location;
    private Country country;
    private Continent continent;
    private String timeZone;
    private Urls urls;

}
