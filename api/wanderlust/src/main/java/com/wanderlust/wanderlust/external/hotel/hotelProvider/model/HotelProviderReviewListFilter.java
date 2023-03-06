package com.wanderlust.wanderlust.external.hotel.hotelProvider.model;

import lombok.Data;

@Data
public class HotelProviderReviewListFilter {

    private String locale;
    private String domain;
    private Long hotelId;

}
