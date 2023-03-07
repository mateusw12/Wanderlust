package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HotelProviderReviewListFilter {

    @NotNull
    @NotBlank
    private String locale;

    @NotNull
    @NotBlank
    private String domain;

    @NotBlank
    private Long hotelId;

}
