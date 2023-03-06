package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore;

import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.countDetail.HotelProviderReviewCountDetails;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.description.HotelProviderReviewOverallDesciption;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.disclaimerUrl.HotelProviderReviewDisclaimerUrl;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.summaryDetail.HotelProviderReviewSummaryDetail;
import lombok.Data;

import java.util.List;

@Data
public class HotelProviderReviewScore {

    private String accessibilityLabel;
    private HotelProviderReviewOverallDesciption overallScoreWithDescriptionA11y;
    private HotelProviderReviewCountDetails propertyReviewCountDetails;
    private String reviewDisclaimer;
    private String reviewDisclaimerLabel;
    private String reviewDisclaimerAccessibilityLabel;
    private HotelProviderReviewDisclaimerUrl reviewDisclaimerUrl;
    private List<HotelProviderReviewSummaryDetail> reviewSummaryDetails;

}
