package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HotelProviderReviewScoreFilter {

    @NotBlank
    @NotNull
    private String locale;

    @NotBlank
    @NotNull
    private String domain;

    @NotNull
    private Long hotelId;

}
