package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore;

import lombok.Data;

@Data
public class HotelProviderReviewScoreFilter {

    private String locale;
    private String domain;
    private Long hotelId;

}
