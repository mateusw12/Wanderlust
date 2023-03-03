package com.wanderlust.wanderlust.external.hotel.booking.model.image;

import lombok.Data;

import java.util.List;

@Data
public class BookingHotelImage {

    private int descriptiontype_id;
    private List<BookingHotelTag> ml_tags;

}
