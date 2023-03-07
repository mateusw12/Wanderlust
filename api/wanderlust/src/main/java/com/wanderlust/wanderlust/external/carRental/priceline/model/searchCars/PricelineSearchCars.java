package com.wanderlust.wanderlust.external.carRental.priceline.model.searchCars;

import lombok.Data;

import java.util.List;

@Data
public class PricelineSearchCars {

    private String itemName;
    private String type;
    private String id;
    private String cityID;
    private String cityName;
    private String airportName;
    private String stateCode;
    private String provinceName;
    private String countryCode;
    private String isoCountryCode;
    private String countryName;
    private String country;
    private Double lat;
    private Double lon;
    private Long timeZoneId;
    private String javaTimeZoneName;
    private String entered;
    private String displayName;
    private String highlightedName;
    private Long rentalLocationsCount;
    private String opaqueParticipantFlag;
    private String rccAirportFlag;
    private String debitCardFlag;
    private String score;
    private String lang;
    private Double rank;
    private List<PricelineAliases> aliases;

}
