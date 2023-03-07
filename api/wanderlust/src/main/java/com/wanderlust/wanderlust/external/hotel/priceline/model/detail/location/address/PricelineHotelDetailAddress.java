package com.wanderlust.wanderlust.external.hotel.priceline.model.detail.location.address;

import lombok.Data;

@Data
public class PricelineHotelDetailAddress {

    private String addressLine1;
    private String cityName;
    private String countryName;
    private String zip;
    private String isoCountryCode;

}
