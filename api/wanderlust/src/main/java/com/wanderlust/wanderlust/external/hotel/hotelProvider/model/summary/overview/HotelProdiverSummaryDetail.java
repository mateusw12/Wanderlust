package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview;

import lombok.Data;

@Data
public class HotelProdiverSummaryDetail {

    private String bannerMessage;
    private String id;
    private String name;
    private String tagline;
    private HotelProviderSummaryOverview overview;
    private HotelProviderSummaryLocation location;

}
