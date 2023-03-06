package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel;

import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.availability.HotelProviderAvailability;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.destination.HotelProviderDestination;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.image.HotelProviderImage;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.price.HotelProviderPrice;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.propertyFees.HotelProviderPropertyFees;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.review.HotelProviderReview;
import lombok.Data;

@Data
public class HotelProviderSearchProperty {

    private String id;
    private String name;
    private Long star;
    private String regionId;
    private HotelProviderAvailability availability;
    private HotelProviderImage image;
    private HotelProviderDestination destinationInfo;
    private HotelProviderPrice price;
    private HotelProviderPropertyFees propertyFees;
    private HotelProviderReview reviews;
}
