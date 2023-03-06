package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.propertyGallery;

import lombok.Data;

import java.util.List;

@Data
public class HotelProviderPropertyGallery {

    private List<ImageGrouped> imagesGrouped;
    private String accessibilityLabel;

}
