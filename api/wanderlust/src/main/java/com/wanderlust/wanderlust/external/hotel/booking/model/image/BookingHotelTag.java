package com.wanderlust.wanderlust.external.hotel.booking.model.image;

import lombok.Data;

import java.util.List;

@Data
public class BookingHotelTag {

    private int tag_id;
    private String tag_name;
    private String tag_type;
    private int confidence;
    private int photo_id;
    private List<BookingHotelTag> tags;

}
