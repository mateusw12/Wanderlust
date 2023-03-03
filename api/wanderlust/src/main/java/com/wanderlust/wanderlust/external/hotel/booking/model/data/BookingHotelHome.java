package com.wanderlust.wanderlust.external.hotel.booking.model.data;

import lombok.Data;

@Data
public class BookingHotelHome {

    private Integer quality_class;
    private int is_single_type_property;
    private int is_vacation_rental;
    private int segment;
    private String group;
    private int is_booking_home;
    private int is_single_unit_property;
    private int is_aparthotel;

}
