package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview;

import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview.location.LocationAddress;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview.location.LocationCoordinates;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview.location.LocationImage;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview.location.LocationMultiRegion;
import lombok.Data;

@Data
public class HotelProviderSummaryLocation {

    private LocationAddress address;
    private LocationCoordinates coordinates;
    private LocationMultiRegion multiCityRegion;
    private LocationImage staticImage;

}
