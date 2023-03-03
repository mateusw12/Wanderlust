package com.wanderlust.wanderlust.external.hotel.booking.model.location;

import lombok.Data;

@Data
public class BookingHotelLocation {

    private String dest_id;

    private String lc;

    private String type;

    private String city_ufi;

    private double latitude;

    private String country;

    private String region;

    private int rtl;

    private String timezone;

    private BookingHotelMaxData b_max_los_data;

    private int has_extended_los;

    private int default_los;

    private int is_fullon;

    private int max_allowed_los;

    private int extended_los;

    private String experiment;

    private int nr_hotels;

    private String cc1;

    private int hotels;

    private double longitude;

    private String dest_type;

    private String name;

    private String label;

    private String city_name;

    private String image_url;

}
