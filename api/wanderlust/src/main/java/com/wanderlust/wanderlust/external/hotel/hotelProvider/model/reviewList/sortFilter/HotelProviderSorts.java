package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.sortFilter;

import lombok.Data;

import java.util.List;

@Data
public class HotelProviderSorts {

    private String travelerType;
    private String label;
    private List<HotelProviderSortOptions> options;
}
