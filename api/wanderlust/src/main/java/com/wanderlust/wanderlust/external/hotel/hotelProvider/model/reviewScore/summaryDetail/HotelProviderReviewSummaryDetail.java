package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.summaryDetail;

import lombok.Data;

@Data
public class HotelProviderReviewSummaryDetail {

    private String label;
    private Double ratingPercentage;
    private HotelProviderFormattedRating formattedRatingOutOfMaxA11y;
}
