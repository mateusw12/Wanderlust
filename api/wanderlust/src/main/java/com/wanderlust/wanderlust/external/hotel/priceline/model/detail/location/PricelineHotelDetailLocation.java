package com.wanderlust.wanderlust.external.hotel.priceline.model.detail.location;

import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.location.address.PricelineHotelDetailAddress;
import lombok.Data;

@Data
public class PricelineHotelDetailLocation {

    private PricelineHotelDetailAddress address;
    private Double longitude;
    private Double latitude;
    private String timeZone;
    private String neighborhoodId;
    private String neighborhoodName;
    private Long cityId;
    private String zoneId;

}
