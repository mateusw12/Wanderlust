package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.propertyGallery;

import lombok.Data;

import java.util.List;

@Data
public class ImageGrouped {

    private String accessibilityLabel;
    private String id;
    private String name;
    private List<Images> images;

}
