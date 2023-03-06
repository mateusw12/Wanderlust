package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.review;

import lombok.Data;

import java.util.List;

@Data
public class HotelProviderReviews {

    private String id;
    private String brandType;
    private HotelProviderScoreDescription reviewScoreWithDescription;
    private String reviewAuthorAttribution;
    private String submissionTimeLocalized;
    private String themes;
    private String title;
    private String text;
    private String stayDuration;
    private List<HotelManagementResponse> managementResponses;
    private String translationInfo;

}
