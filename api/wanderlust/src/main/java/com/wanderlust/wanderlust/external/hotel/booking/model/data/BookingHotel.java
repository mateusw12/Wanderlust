package com.wanderlust.wanderlust.external.hotel.booking.model.data;

import lombok.Data;

import java.util.List;

@Data
public class BookingHotel {

    private String url;
    private String name;
    private int preferred_plus;
    private int city_id;
    private int district_id;
    private int is_single_unit_vr;
    private int ranking;
    private String review_score_word;
    private List<String> languages_spoken;
    private int maxrate;
    private String review_score;
    private int main_photo_id;
    private int minrate;
    private int hoteltype_id;
    private int review_nr;
    private BookingHotelLocation location;
    private String email;
    private String main_photo_url;
    private String zip;
    private int hotel_class;
    private String country;
    private String countrycode;
    private String hotel_facilities_filtered;
    private String district;
    private int class_is_estimated;
    private String hotel_facilities;
    private String address;
    private int is_vacation_rental;
    private BookingHotelCheckout checkout;
    private String currencycode;
    private int hotel_id;
    private BookingHotelCheckin checkin;
    private int preferred;
    private String city;
    private String entrance_photo_url;
    private BookingHotelHome booking_home;

}
