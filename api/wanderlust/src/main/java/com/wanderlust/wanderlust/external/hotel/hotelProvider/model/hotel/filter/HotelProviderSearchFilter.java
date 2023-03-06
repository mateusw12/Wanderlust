package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.filter;

import lombok.Data;

import java.util.Date;

@Data
public class HotelProviderSearchFilter {

    private String domain;
    private HotelProviderSortOrder sortOrder;
    private Date checkoutDate;
    private Date checkinDate;
    private Long regionId;
    private Long adultsNumber;

}
