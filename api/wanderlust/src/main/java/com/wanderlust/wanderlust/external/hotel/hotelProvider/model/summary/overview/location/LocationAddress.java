package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview.location;

import lombok.Data;

@Data
public class LocationAddress {

    private String addressLine;
    private String city;
    private String province;
    private String countryCode;
    private String firstAddressLine;
    private String secondAddressLine;

}
