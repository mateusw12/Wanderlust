package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.sortFilter;

import lombok.Data;

@Data
public class HotelProviderSortOptions {

    private String label;
    private Boolean isSelected;
    private String optionValue;
    private String description;

}
