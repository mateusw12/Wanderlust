package com.wanderlust.wanderlust.external.airportAndFlight.skyscanner.model;

import lombok.Data;

@Data
public class SkyscannerSearchAirportData {

    private String PlaceId;
    private String PlaceName;
    private String LocalizedPlaceName;
    private String CountryId;
    private String CityId;
    private String IataCode;
    private String CountryName;
    private String PlaceNameEn;
    private String CityName;
    private String CityNameEn;
    private String GeoId;
    private String GeoContainerId;
    private String Location;
    private String ResultingPhrase;
    private String UntransliteratedResultingPhrase;

}
