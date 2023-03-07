package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.filter;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class HotelProviderSearchFilter {

    @NotNull
    @NotBlank
    private String domain;

    private HotelProviderSortOrder sortOrder;

    private Date checkoutDate;

    private Date checkinDate;

    @NotNull
    private Long regionId;

    private Long adultsNumber;

}
