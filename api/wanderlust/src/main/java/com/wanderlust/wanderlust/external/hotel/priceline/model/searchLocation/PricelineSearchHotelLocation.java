package com.wanderlust.wanderlust.external.hotel.priceline.model.searchLocation;

import lombok.Data;

@Data
public class PricelineSearchHotelLocation {

    private String itemName;
    private String id;
    private String cityID;
    private String type;
    private double lat;
    private double lon;
    private int proximity;
    private Object savedTravelStartDate;
    private Object savedTravelEndDate;
    private String cityName;
    private Object stateCode;
    private String provinceName;
    private double score;
    private int radius;
    private double rank;
    private double globalScore;
    private int globalScoreReducedCityBoost;
    private int globalScoreWOHotelCountNormalize;
    private String country;
    private Object address;
    private Object zip;
    private String countryName;
    private String countryCode;
    private int poiCategoryTypeId;
    private Object poiCategoryName;
    private Object poiID;
    private Object seType;
    private int gmtOffset;
    private String entered;
    private Object highlightedName;
    private boolean fromSavedSearch;

}
